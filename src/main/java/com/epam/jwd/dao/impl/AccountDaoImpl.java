package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.AccountDao;
import com.epam.jwd.dao.connection.ConnectionPool;
import com.epam.jwd.entity.Account;
import com.epam.jwd.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private static final String FIND_ACCOUNT_BY_ID = "select a.id, a.login, a.password from account a where id = ?";
    private static final String FIND_ACCOUNT_BY_LOGIN = "select a.id, a.login, a.password from account a where login = ?";
    private static final String FIND_ACCOUNT_BY_LOGIN_AND_PASSWORD = "select a.id, a.login, a.password " +
            "from account a where a.login = ? and a.password = ?";
    private static final String GET_ALL_ACCOUNT = "select a.id, a.login, a.password from account a";
    private static final String CREATE_ACCOUNT = "insert into account (login, password) VALUES (?, ?)";
    private static final String UPDATE_PASSWORD = "update account set password = ? where id = ?";
    private static final String DELETE_ACCOUNT = "delete from account where id = ?";

    AccountDaoImpl() {
    }

    @Override
    public List<Account> findAllAccount() throws DaoException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_ACCOUNT)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password"));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return accounts;
    }

    @Override
    public Optional<Account> findAccountById(int accountId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ACCOUNT_BY_ID)) {

            prepareStatement.setInt(1, accountId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Account(resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password")));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Account> findAccountByLogin(String login) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ACCOUNT_BY_LOGIN)) {

            prepareStatement.setString(1, login);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Account(resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password")));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Account> findAccountByLoginAndPassword(String accountLogin, String accountPassword) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ACCOUNT_BY_LOGIN_AND_PASSWORD)) {
            prepareStatement.setString(1, accountLogin);
            prepareStatement.setString(2, accountPassword);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Account(resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password")));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public void createAccount(String login, String password) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ACCOUNT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updatePassword(Long accountId, String newPassword) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setLong(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteAccount(Account account) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setLong(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
