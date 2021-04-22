package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;

import java.util.Optional;

public interface AccountDao {
    Optional<Account> findAccountById(int accountId) throws DaoException;
    /**TO DO
     * add create
     *
     * */
    void createAccount();
    void updateAccount(Account account);
    void deleteAccount(Account account);
}
