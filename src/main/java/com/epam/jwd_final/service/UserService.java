package com.epam.jwd_final.service;

import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById (Long id) throws ServiceException;
    Optional<User> findUserByAccountId (Long id) throws ServiceException;
}
