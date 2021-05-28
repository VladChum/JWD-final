package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
    Optional<Admin> findAdminById(int adminId) throws DaoException;

    Optional<Admin> findAdminByAccountId(int accountId) throws DaoException;

    void createAdmin(Long accountId) throws DaoException;

    void deleteAdmin(Long id) throws DaoException;

    List<Account> findAllAdminAccount() throws DaoException;
}
