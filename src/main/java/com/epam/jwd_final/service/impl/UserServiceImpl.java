package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.UserDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = DaoProvider.INSTANCE.getUserDao();

    @Override
    public Optional<User> findUserById(Long id) throws ServiceException {
        try {
            return userDao.findUserById(id.intValue());
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByAccountId(Long id) throws ServiceException {
        try {
            return userDao.findUserByAccountId(id.intValue());
        } catch (DaoException e) {
            throw  new ServiceException(e);
        }
    }
}
