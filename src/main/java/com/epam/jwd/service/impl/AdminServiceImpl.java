package com.epam.jwd.service.impl;

import com.epam.jwd.dao.AdminDao;
import com.epam.jwd.dao.impl.DaoProvider;
import com.epam.jwd.entity.Account;
import com.epam.jwd.entity.Admin;
import com.epam.jwd.exception.DaoException;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.AdminService;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = DaoProvider.INSTANCE.getAdminDao();

    AdminServiceImpl() {

    }

    @Override
    public Optional<Admin> findAdminById(Long id) throws ServiceException {
        try {
            return adminDao.findAdminById(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Admin> findAdminByAccountId(Long id) throws ServiceException {
        try {
            return adminDao.findAdminByAccountId(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Account> findAllAdminAccounts() throws ServiceException {
        try {
            return adminDao.findAllAdminAccount();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createAdmin(Admin admin) throws ServiceException {
        try {
            adminDao.createAdmin(admin.getAccountId());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long accountId) throws ServiceException {
        try {
            if (adminDao.findAdminByAccountId(accountId.intValue()).isPresent()) {
                Admin admin = adminDao.findAdminByAccountId(accountId.intValue()).get();
                adminDao.deleteAdmin(admin.getId());
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
