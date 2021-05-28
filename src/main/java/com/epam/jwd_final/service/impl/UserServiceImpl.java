package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.UserDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.UserService;

import java.util.List;
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

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            return userDao.getAllUser();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            userDao.createUser(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long userId) throws ServiceException {
        try {
            userDao.deleteUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
