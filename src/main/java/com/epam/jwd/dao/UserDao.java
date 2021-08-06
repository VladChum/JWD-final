package com.epam.jwd.dao;

import com.epam.jwd.entity.User;
import com.epam.jwd.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    /**
     * Find all user in db
     *
     * @return list of users
     */
    List<User> getAllUser() throws DaoException;

    /**
     * Find user in db by user id
     *
     * @param userId - account id
     * @return user
     */
    Optional<User> findUserById(int userId) throws DaoException;

    /**
     * Find user in db by account id
     *
     * @param userId - account id
     * @return user
     */
    Optional<User> findUserByAccountId(int userId) throws DaoException;

    /**
     * Add new user in db
     *
     * @param user - new user
     */
    void createUser(User user) throws DaoException;

    /**
     * Add amount for user deposit and update user balance in db
     *
     * @param user - user with new balancce
     */
    void updateBalance(User user) throws DaoException;

    /**
     * Delete user from db
     *
     * @param id - user id
     */
    void deleteUser(Long id) throws DaoException;

    /**
     * Cheng user status in db by user
     *
     * @param user - user with new data
     * @param statusId - new status id
     */
    void updateUserStatus(User user, Long statusId) throws DaoException;

    /**
     * Update user email
     *
     * @param userId - user id
     * @param email - new email
     */
    void updateEmail(Long userId, String email) throws DaoException;

    /**
     * Update user phone
     *
     * @param userId - user id
     * @param phone - new phone
     */
    void updatePhone(Long userId, String phone) throws DaoException;
}
