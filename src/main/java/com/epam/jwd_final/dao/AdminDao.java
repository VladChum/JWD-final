package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;

import java.util.Optional;

public interface AdminDao {
    Optional<Admin> findAdminById(int adminId) throws DaoException;
    Optional<Admin> findAdminByAccountId(int accountId) throws DaoException;
    /**todo
     *
     * add create
     * add dto
     * */
    void createAdmin(Long accountId) throws DaoException;
    void deleteAdmin(Admin admin) throws DaoException;
}
