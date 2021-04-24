package com.epam.jwd_final.dao;

import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUser() throws DaoException;
    Optional<User> findUserById(int userId) throws DaoException;
    /**todo
     *
     * add create
     *
     *
     * add dto
     *
     * */
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    void updateUserStatus(Status status);
}
