package com.epam.jwd.service;


import com.epam.jwd.entity.Account;
import com.epam.jwd.entity.Admin;
import com.epam.jwd.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    /**
     * Find admin in db by id
     *
     * @param id - admin id
     * @return admin if it exist
     */
    Optional<Admin> findAdminById(Long id) throws ServiceException;

    /**
     * Find admin in db by account id
     *
     * @param id - account id
     * @return admin if it exist
     */
    Optional<Admin> findAdminByAccountId(Long id) throws ServiceException;

    /**
     * Find all admin accounts in db
     *
     * @return list of admin accounts
     */
    List<Account> findAllAdminAccounts() throws ServiceException;

    /**
     * Add new admin in db
     *
     * @param admin - admin who will be add
     */
    void createAdmin(Admin admin) throws ServiceException;

    /**
     * Delete admin from db by id
     *
     * @param adminId - admin id
     */
    void delete(Long adminId) throws ServiceException;
}
