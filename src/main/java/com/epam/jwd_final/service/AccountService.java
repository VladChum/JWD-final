package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ServiceException;

import java.util.Optional;

public interface AccountService {
    /**
     * Find account in db by login and password
     *
     * @param login    - account login
     * @param password - account password
     * @return account if it exists
     */
    Optional<Account> findAccountByLoginAndPassword(String login, String password) throws ServiceException;

    /**
     * Find account in db by id
     *
     * @param id - account id
     * @return account if it exists
     */
    Optional<Account> findAccountById(Long id) throws ServiceException;

    /**
     * Find account in db by login
     *
     * @param login - account id
     * @return account if it exists
     */
    Optional<Account> findAccountByLogin(String login) throws ServiceException;

    /**
     * Add new account in db
     *
     * @param login    - account login
     * @param password - account password
     * @return id new account
     */
    Long addAccount(String login, String password) throws ServiceException;

    /**
     * Update password for account by id
     *
     * @param id          - account id
     * @param newPassword - new password for account
     * @return account if it exists
     */
    void updatePassword(Long id, String newPassword) throws ServiceException;

    /**
     * Check if exist account in db
     *
     * @param login - account login
     * @return search result in db
     */
    boolean checkExistence(String login) throws ServiceException;
}
