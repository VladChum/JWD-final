package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AdminDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Admin;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AdminDaoImpl implements AdminDao {
    private static final String FIND_ADMIN_BY_ID = "select a.id, a.account_id " +
            "from admin a " +
            "inner join account on account.id = a.account_id " +
            "where a.id= ?";
    private static final String FIND_ADMIN_BY_ACCOUNT_ID = "select a.id, a.account_id " +
            "from admin a " +
            "inner join account on account.id = a.account_id " +
            "where a.account_id= ?";
    private static final String CREATE_ADMIN = "insert into admin (account_id) VALUES (?)";
    private static final String UPDATE_ACCOUNT = "update account set password = ? where login = ?";
    private static final String DELETE_ADMIN = "delete from admin where id = ?";

    AdminDaoImpl() {
    }

    @Override
    public Optional<Admin> findAdminById(int adminId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADMIN_BY_ID)) {

            prepareStatement.setInt(1, adminId);
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
    public Optional<Admin> findAdminByAccountId(int accountId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADMIN_BY_ACCOUNT_ID)) {

            prepareStatement.setInt(1, accountId);
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
    public void createAdmin(Long accountId) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMIN)) {
            preparedStatement.setInt(1, accountId.intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAdmin(Admin admin) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN)) {
            preparedStatement.setLong(1, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
