package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ServiceException;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findAccountByLogin (String login, String password) throws ServiceException;
}
