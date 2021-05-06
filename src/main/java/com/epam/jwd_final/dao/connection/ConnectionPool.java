package com.epam.jwd_final.dao.connection;

import com.epam.jwd_final.exception.ConnectionPoolException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private final String DRIVER;
    private final int CONNECTION_POOL_SIZE;

    private BlockingQueue<ConnectionProxy> freeConnections;
    private Queue<ConnectionProxy> givenAwayConnections;

    ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.URL = dbResourceManager.getValue(DBParameter.DB_URL);
        this.USER = dbResourceManager.getValue(DBParameter.DB_USER);
        this.PASSWORD = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        this.CONNECTION_POOL_SIZE = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_CONNECTION_POOL_SIZE));
        this.DRIVER = dbResourceManager.getValue(DBParameter.DB_DRIVER);

        init();
        givenAwayConnections = new ArrayDeque<>();
    }

    private void init() {

        freeConnections = new LinkedBlockingDeque<>(CONNECTION_POOL_SIZE);
        Connection connection;
        try {
            Class.forName(DRIVER);
            for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                freeConnections.add(new ConnectionProxy(connection));
            }
        } catch (SQLException | ClassNotFoundException e) {
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
            LOGGER.log(Level.ERROR, e.getMessage() + " " + e);
            e.printStackTrace();
        }
        LOGGER.log(Level.DEBUG, "get Connection");
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
        LOGGER.log(Level.DEBUG, "Connection release");
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