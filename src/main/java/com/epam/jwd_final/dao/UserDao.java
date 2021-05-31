package com.epam.jwd_final.dao;
;
import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUser() throws DaoException;
    Optional<User> findUserById(int userId) throws DaoException;
    Optional<User> findUserByAccountId(int userId) throws DaoException;
    void createUser(User user) throws DaoException;
    void updateUser(User user) throws DaoException;
    void updateBalance(User user) throws DaoException;
    void deleteUser(Long id) throws DaoException;
    void updateUserStatus(User user,  Long statusId) throws DaoException;
}
