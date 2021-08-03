package com.epam.jwd.service.impl;

import com.epam.jwd.dao.UserDao;
import com.epam.jwd.dao.impl.DaoProvider;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.DaoException;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = DaoProvider.INSTANCE.getUserDao();

    UserServiceImpl() {

    }

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

    @Override
    public List<User> findUserByCriteria(User userWithCriteria) throws ServiceException {
        List<User> allUsers = findAll();

        return allUsers.stream().filter(user -> (
                (user.getFirstName().equalsIgnoreCase(userWithCriteria.getFirstName()) || userWithCriteria.getFirstName() == null)
                        && (user.getLastName().equalsIgnoreCase(userWithCriteria.getLastName())
                        || userWithCriteria.getLastName() == null)
                        && (user.getStatus().equals(userWithCriteria.getStatus())
                        || userWithCriteria.getStatus() == null)
                        && (user.getAccountId().equals(userWithCriteria.getAccountId())
                        || userWithCriteria.getAccountId() == null)
                        && (user.getPhone().equals(userWithCriteria.getPhone())
                        || userWithCriteria.getPhone() == null)
                        && (user.getEmail().equals(userWithCriteria.getEmail())
                        || userWithCriteria.getEmail() == null)
        )).collect(Collectors.toList());
    }
}
