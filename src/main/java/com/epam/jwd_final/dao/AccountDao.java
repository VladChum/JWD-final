package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    List<Account> findAllAccount() throws DaoException;

    Optional<Account> findAccountById(int accountId) throws DaoException;

    Optional<Account> findAccountByLogin(String login) throws DaoException;

    Optional<Account> findAccountByLoginAndPassword(String accountLogin, String accountPassword) throws DaoException;

    void createAccount(String login, String password) throws DaoException;

    void updatePassword(Long accountId, String newPassword) throws DaoException;

    void deleteAccount(Account account) throws DaoException;
}
