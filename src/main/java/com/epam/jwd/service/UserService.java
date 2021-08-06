package com.epam.jwd.service;

import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Find user in db by account id
     *
     * @param id - account id
     * @return user
     */
    Optional<User> findUserByAccountId(Long id) throws ServiceException;

    /**
     * Find user in db by user id
     *
     * @param id - user id
     * @return user
     */
    Optional<User> findUserById(Long id) throws ServiceException;

    /**
     * Find all user in db
     *
     * @return list of users
     */
    List<User> findAll() throws ServiceException;

    /**
     * Add new user in db
     *
     * @param user - new user
     */
    void addUser(User user) throws ServiceException;

    /**
     * Delete user from db
     *
     * @param userId - user id
     */
    void delete(Long userId) throws ServiceException;

    /**
     * Cheng user status in db by user
     *
     * @param user - user with new data
     * @param statusId - new status id
     */
    void changeStatus(User user, Long statusId) throws ServiceException;

    /**
     * Add amount for user deposit and update user balance in db
     *
     * @param userId - user id
     * @param amount - the amount to be deposited into the account
     */
    void updateBalance(Long userId, BigDecimal amount) throws ServiceException;

    /**
     * Update user email
     *
     * @param userId - user id
     * @param email - new email
     */
    void updateEmail(Long userId, String email) throws ServiceException;

    /**
     * Update user phone
     *
     * @param userId - user id
     * @param phone - new phone
     */
    void updatePhone(Long userId, String phone) throws ServiceException;

    /**
     * Sort users by status in new array
     *
     * @param users - list users
     * @return array of 3 elements 0 - active, 1 - baned, 2- suspended
     */
    int[] findAllUsersByStatus(List<User> users);

    /**
     * Find all users with this criteria
     *
     * @param userWithCriteria - user account with options
     * @return list of find users
     */
    List<User> findUserByCriteria(User userWithCriteria) throws ServiceException;
}
