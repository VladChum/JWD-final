package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;

import java.util.Optional;

public interface AdminDao {
    Optional<Admin> findAdminById(int adminId) throws DaoException;
    /**todo
     *
     * add create
     * add dto
     * */
    void createAdmin(Long accountId);
    void deleteAdmin(Admin admin);
}
