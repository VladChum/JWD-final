package com.epam.jwd_final.db;

import com.epam.jwd_final.exception.ConnectionPoolException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private final int CONNECTION_POOL_SIZE = 16;
    private final String URL;
    private final String USER;
    private final String PASSWORD;

    private BlockingQueue<ConnectionProxy> freeConnections;
    private Queue<ConnectionProxy> givenAwayConnections;

    ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();

        this.URL = dbResourceManager.getValue(DBParameter.DB_URL);
        this.USER = dbResourceManager.getValue(DBParameter.DB_USER);
        this.PASSWORD = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        init();
        givenAwayConnections = new ArrayDeque<>();
    }

    private void init() {
        freeConnections = new LinkedBlockingDeque<>(CONNECTION_POOL_SIZE);
        Connection connection;
        try {
            for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                freeConnections.add(new ConnectionProxy(connection));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.FATAL, "ConnectionPool was not initialized", e);
            throw new RuntimeException("ConnectionPool was not initialized", e);
        }
    }

    public Connection getConnection() {
        ConnectionProxy connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws ConnectionPoolException {
        if (connection.getClass() == ConnectionProxy.class) {
            givenAwayConnections.remove(connection);
            freeConnections.offer((ConnectionProxy) connection);
        } else {
            LOGGER.log(Level.FATAL, "Connection is not a ProxyConnection");
            throw new ConnectionPoolException("Attempt to close connection not from connection pool");
        }
        LOGGER.log(Level.INFO, "Connection release");
    }

    public void destroyPool() throws ConnectionPoolException {
        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException e) {
                throw new ConnectionPoolException("Unable to destroy pool connection");
            }
        }
    }

}