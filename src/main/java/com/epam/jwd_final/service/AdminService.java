package com.epam.jwd_final.service;


import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.ServiceException;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> findAdminById (Long id) throws ServiceException;
    Optional<Admin> findAdminByAccountId(Long id) throws ServiceException;
}
