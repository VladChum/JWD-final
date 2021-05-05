package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    List<Account> getAllAccount() throws DaoException;
    Optional<Account> findAccountById(int accountId) throws DaoException;
    Optional<Account> findAccountByLogin(String accountLogin, String accountPassword) throws DaoException;
    /**todo
     *
     * add create
     *
     *
     * add dto
     *
     * */
    void createAccount(String login, String password);
    void updateAccount(Account account);
    void deleteAccount(Account account);
}
