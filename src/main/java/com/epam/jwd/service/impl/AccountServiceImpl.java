package com.epam.jwd.service.impl;

import com.epam.jwd.dao.AccountDao;
import com.epam.jwd.dao.impl.DaoProvider;
import com.epam.jwd.entity.Account;
import com.epam.jwd.exception.DaoException;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AccountService;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao = DaoProvider.INSTANCE.getAccountDao();

    AccountServiceImpl() {
        
    }
    
    @Override
    public Optional<Account> findAccountByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return accountDao.findAccountByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Account> findAccountByLogin(String login) throws ServiceException {
        try {
           return accountDao.findAccountByLogin(login);
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
            if (accountDao.findAccountByLogin(login).isPresent()) {
                result = true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
