package com.epam.jwd.dao;

import com.epam.jwd.entity.Account;
import com.epam.jwd.entity.Admin;
import com.epam.jwd.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
    /**
     * Find admin in db by id
     *
     * @param adminId - admin id
     * @return admin
     */
    Optional<Admin> findAdminById(int adminId) throws DaoException;

    /**
     * Find admin in db by account id
     *
     * @param accountId - account id
     * @return admin
     */
    Optional<Admin> findAdminByAccountId(int accountId) throws DaoException;

    /**
     * Add admin in db
     *
     * @param accountId - account id for new admin
     */
    void createAdmin(Long accountId) throws DaoException;

    /**
     * Delete admin from db
     *
     * @param id - admin id
     */
    void deleteAdmin(Long id) throws DaoException;

    /**
     * Find all admin accounts in db
     *
     * @return list accounts
     */
    List<Account> findAllAdminAccount() throws DaoException;
}
