package com.epam.jwd_final;

import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;


public class Main {
    public static void main(String[] args) throws DaoException, ConnectionPoolException {
//        String login = "admin";
//        String password = "admin";
//
//
//        try {
//            if (!ServiceProvider.INSTANCE.getAccountService().findAccountByLogin(login, password).isPresent()) {
//                System.out.println("no");
//            } else {
//                Account account = DaoProvider.INSTANCE.getAccountDao().findAccountByLogin(login, password).get();
//                if (DaoProvider.INSTANCE.getAdminDao().findAdminById(account.getId().intValue()).isPresent()) {
//                    System.out.println("admin");
//                } else if (DaoProvider.INSTANCE.getUserDao().findUserById(account.getId().intValue()).isPresent()) {
//                    System.out.println("user");
//                }
//            }
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
    }
}
