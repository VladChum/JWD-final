package com.epam.jwd_final.service.impl;

import com.epam.jwd_final.dao.UserDao;
import com.epam.jwd_final.dao.impl.DaoProvider;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;
import com.epam.jwd_final.exception.ServiceException;
import com.epam.jwd_final.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = DaoProvider.INSTANCE.getUserDao();

    @Override
    public Optional<User> findUserById(Long id) throws ServiceException {
        try {
            return userDao.findUserById(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByAccountId(Long id) throws ServiceException {
        try {
            return userDao.findUserByAccountId(id.intValue());
        } catch (DaoException e) {
            throw new ServiceException(e);
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

    @Override
    public void changeStatus(User user, Long statusId) throws ServiceException {
        try {
            userDao.updateUserStatus(user, statusId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateBalance(Long userId, BigDecimal amount) throws ServiceException {
        User user = findUserById(userId).get();
        amount = user.getBalance().add(amount);
        user.setBalance(amount);
        try {
            userDao.updateBalance(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateEmail(Long userId, String email) throws ServiceException {
        try {
            userDao.updateEmail(userId, email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePhone(Long userId, String phone) throws ServiceException {
        try {
            userDao.updatePhone(userId, phone);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int[] findAllUsersByStatus(List<User> users) {
        int[] usersByStatus = new int[]{0, 0, 0};
        for (User user : users) {
            if (user.getStatus().getId() == 1L) {
                usersByStatus[0]++;
            } else if (user.getStatus().getId() == 2L) {
                usersByStatus[1]++;
            } else {
                usersByStatus[2]++;
            }
        }
        return usersByStatus;
    }
}
