package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ServiceException;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountByLoginAndPassword(String login, String password) throws ServiceException;

    Optional<Account> findAccountById(Long id) throws ServiceException;

    Long addAccount(String login, String password) throws ServiceException;
}
