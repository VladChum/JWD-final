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
        List<Account> accounts = new ArrayList<>(DaoProvider.INSTANCE.getAccountDao().getAllAccount());
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
        List<User> user = new ArrayList<>(DaoProvider.INSTANCE.getUserDao().getAllUser());
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i));
        }
        System.out.println(DaoProvider.INSTANCE.getUserDao().findUserById(1).toString());
//
//        User user1 = new User(3L, "qwewwwwee", "qwe", "+37523131212", "qweqqweqeq", Status.ACTIVATE);
//        DaoProvider.INSTANCE.getUserDao().createUser(user1);
//        DaoProvider.INSTANCE.getUserDao().deleteUser(user.get(2));
        DaoProvider.INSTANCE.getAdminDao().createAdmin(7L);
//        System.out.println(DaoProvider.INSTANCE.getAdminDao().findAdminById(1).toString());
//        DaoProvider.INSTANCE.getAdminDao().deleteAdmin(DaoProvider.INSTANCE.getAdminDao().findAdminById(2).get());
    }
}
