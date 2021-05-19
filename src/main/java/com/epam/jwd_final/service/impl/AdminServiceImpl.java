package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.AdminDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.AdminService;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = DaoProvider.INSTANCE.getAdminDao();

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
}
