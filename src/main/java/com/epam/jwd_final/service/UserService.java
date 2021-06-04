package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByAccountId(Long id) throws ServiceException;

    Optional<User> findUserById(Long id) throws ServiceException;

    List<User> findAll() throws ServiceException;

    void addUser(User user) throws ServiceException;

    void delete(Long userId) throws ServiceException;

    void chengStatus(User user, Long statusId) throws ServiceException;

    void updateBalance(Long userId, BigDecimal amount) throws ServiceException;

    void updateEmail(Long userId, String email) throws ServiceException;

    void updatePhone(Long userId, String phone) throws ServiceException;
}
