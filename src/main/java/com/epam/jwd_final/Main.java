package com.epam.jwd_final;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.dao.impl.AccountDaoImpl;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DaoException, ConnectionPoolException {
//
//        try  {
//            Connection connection = ConnectionPool.INSTANCE.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getLong(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
//            }
//            ConnectionPool.INSTANCE.releaseConnection(connection);
//            ConnectionPool.INSTANCE.destroyPool();
//        } catch (SQLException | ConnectionPoolException throwables) {
//            throwables.printStackTrace();
//        }

        List<Account> accounts = new ArrayList<>(DaoProvider.INSTANCE.getAccountDao().getAllAccount());
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
        List<User> user = new ArrayList<>(DaoProvider.INSTANCE.getUserDao().getAllUser());
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i));
        }
        System.out.println(DaoProvider.INSTANCE.getUserDao().findUserById(1).toString());
        User user1 = new User(2L, "qwe", "qwe", "+37523131231212", "qweqweqeq", Status.ACTIVATE);
        DaoProvider.INSTANCE.getUserDao().createUser(user1);
    }
}
