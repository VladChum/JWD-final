package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AdminDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminDaoImpl implements AdminDao {
    private static final String FIND_ADMIN_BY_ID = "select a.id, a.account_id " +
            "from admin a " +
            "inner join account on account.id = a.account_id " +
            "where a.id= ?";
    private static final String FIND_ALL_ADMIN_ACCOUNT = "select ac.id, ac.login, ac.password " +
            "from admin a " +
            "inner join account ac on ac.id = a.account_id";
    private static final String FIND_ADMIN_BY_ACCOUNT_ID = "select a.id, a.account_id " +
            "from admin a " +
            "inner join account on account.id = a.account_id " +
            "where a.account_id= ?";
    private static final String CREATE_ADMIN = "insert into admin (account_id) VALUES (?)";
    private static final String UPDATE_ACCOUNT = "update account set password = ? where login = ?";
    private static final String DELETE_ADMIN = "delete admin, account " +
            "from admin " +
            "inner join account on admin.account_id = account.id " +
            "where admin.id = ?";

    AdminDaoImpl() {
    }

    @Override
    public Optional<Admin> findAdminById(int adminId) throws DaoException {
        return findAccount(adminId, FIND_ADMIN_BY_ID);
    }

    @Override
    public Optional<Admin> findAdminByAccountId(int accountId) throws DaoException {
        return findAccount(accountId, FIND_ADMIN_BY_ACCOUNT_ID);
    }

    @Override
    public void createAdmin(Long accountId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMIN)) {
            preparedStatement.setInt(1, accountId.intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN)) {
            preparedStatement.setLong(1, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Optional<Admin> findAccount(int id, String request) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(request)) {
            prepareStatement.setInt(1, id);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Admin(resultSet.getLong("id")
                            , resultSet.getLong(2)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Account> findAllAdminAccount() throws DaoException {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_ADMIN_ACCOUNT)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password")
                    );
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return accounts;
    }
}
