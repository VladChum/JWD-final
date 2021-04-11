package com.epam.jwd_final.db;

import com.epam.jwd_final.exception.ConnectionPoolException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private final int CONNECTION_POOL_SIZE = 16;
    private  String url;
    private  String user;
    private  String password;

    private BlockingQueue<ConnectionProxy> freeConnections;
    private Queue<ConnectionProxy> givenAwayConnections;

    ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();

        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        init();
        givenAwayConnections = new ArrayDeque<>(CONNECTION_POOL_SIZE);
    }

    private BlockingQueue<ConnectionProxy> init() {
        freeConnections = new LinkedBlockingDeque<>(CONNECTION_POOL_SIZE);
        Connection connection;
        try {
            for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                connection = DriverManager.getConnection(url , user, password);
                freeConnections.offer(new ConnectionProxy(connection));
            }
        } catch (SQLException e) {
//            LOGGER.log(Level.FATAL, "ConnectionPool was not initialized", e);
            throw new RuntimeException("ConnectionPool was not initialized", e);
        }
        return freeConnections;
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
        //add connection exception
        if (connection != null) {
            if (connection instanceof ConnectionProxy && givenAwayConnections.remove(connection)) {
                try {
                    freeConnections.put((ConnectionProxy) connection);
                } catch (InterruptedException e) {
//                    LOGGER.log(Level.FATAL, "Connection is not a ProxyConnection");
                    throw new ConnectionPoolException("Connection is not a ProxyConnection", e);
                }
            }
        }

    }

    public void destroyPool() throws ConnectionPoolException {
        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            try {
                if (!freeConnections.isEmpty()) {
                    ConnectionProxy connectionProxy = freeConnections.take();
                    connectionProxy.reallyClose();
//                    freeConnections.take().reallyClose();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() throws ConnectionPoolException {
//        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (SQLException e) {
//                //log
//                e.printStackTrace();
//            }
//        });

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
//                LOGGER.log(Level.ERROR, "Registered drivers are missing", e);
                throw new ConnectionPoolException("Registered drivers are missing", e);
            }
        }
    }
}