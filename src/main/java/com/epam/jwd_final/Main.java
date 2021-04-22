package com.epam.jwd_final;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.dao.impl.AccountDaoImpl;
import com.epam.jwd_final.exception.ConnectionPoolException;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try  {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
            ConnectionPool.INSTANCE.destroyPool();
        } catch (SQLException | ConnectionPoolException throwables) {
            throwables.printStackTrace();
        }

    }


}
