package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    /**
     * Find all account in db
     *
     * @return list accounts
     */
    List<Account> findAllAccount() throws DaoException;

    /**
     * Find account in db by account id
     *
     * @return account
     */
    Optional<Account> findAccountById(int accountId) throws DaoException;

    /**
     * Find account in db by login
     *
     * @return account
     */
    Optional<Account> findAccountByLogin(String login) throws DaoException;

    /**
     * Find account in db by login and password
     *
     * @param accountLogin    - account login
     * @param accountPassword - account password
     * @return account
     */
    Optional<Account> findAccountByLoginAndPassword(String accountLogin, String accountPassword) throws DaoException;

    /**
     * Add new account in db
     *
     * @param login    - account login
     * @param password - account password
     */
    void createAccount(String login, String password) throws DaoException;

    /**
     * Update account password in db
     *
     * @param accountId   - account id
     * @param newPassword - new account password
     */
    void updatePassword(Long accountId, String newPassword) throws DaoException;

    /**
     * Delete account from db
     *
     * @param account - account to be deleted
     */
    void deleteAccount(Account account) throws DaoException;
}
