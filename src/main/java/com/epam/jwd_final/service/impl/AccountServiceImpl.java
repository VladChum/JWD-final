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

    @Override
    public Optional<Account> findAccountByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return accountDao.findAccountByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Account> findAccountById(Long id) throws ServiceException {
        try {
            return accountDao.findAccountById(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Long addAccount(String login, String password) throws ServiceException {
        try {
            accountDao.createAccount(login, password);
            return findAccountByLoginAndPassword(login, password).get().getId();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePassword(Long id, String newPassword) throws ServiceException {
        try {
            accountDao.updatePassword(id, newPassword);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean checkExistence(String login) throws ServiceException {
        boolean result = false;
        try {
            if (!accountDao.findAccountByLogin(login).isEmpty()) {
                result = true;
            }
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }
        return result;
    }
}
