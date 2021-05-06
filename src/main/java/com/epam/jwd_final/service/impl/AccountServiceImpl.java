package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AccountService;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao = DaoProvider.INSTANCE.getAccountDao();


    public AccountServiceImpl() {
    }

    @Override
    public Optional<Account> findAccountByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return accountDao.findAccountByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
