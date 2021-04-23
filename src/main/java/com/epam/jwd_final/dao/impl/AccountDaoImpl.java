package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.ConnectionPoolException;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private final Connection transactionConnection;
    private final boolean isConnection;

    private static final String FIND_ACCOUNT_BY_ID = "select a.id, a.login, a.password from account a where id = ?";
    private static final String GET_ALL_ACCOUNT = "select a.id, a.login, a.password from account a";

    private static final String CREATE_ACCOUNT = "insert into account (login, password) VALUES (?, ?)";
    private static final String UPDATE_ACCOUNT = "update account set password = ? where login = ?";
    private static final String DELETE_ACCOUNT = "delete from account where id = ?";

    AccountDaoImpl() {
        this.transactionConnection = null;
        this.isConnection = false;
    }

    public AccountDaoImpl(Connection transactionConnection) {
        this.transactionConnection = transactionConnection;
        this.isConnection = true;
    }

    public Connection getConnection() {
        return isConnection ? transactionConnection : ConnectionPool.INSTANCE.getConnection();
    }

    @Override
    public List<Account> getAllAccount() throws DaoException, ConnectionPoolException {
        Connection connection = getConnection();
        List<Account> accounts = new ArrayList<Account>();

        try (Connection connectionResource = isConnection ? null : connection;
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_ACCOUNT)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account(resultSet.getLong("id"), resultSet.getString("login"), resultSet.getString("password"));
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
        Connection connection = getConnection();

        try (Connection connectionResource = isConnection ? null : connection;
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ACCOUNT_BY_ID)) {

            prepareStatement.setInt(1, accountId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Account(resultSet.getLong("id")
                            , resultSet.getString("login")
                            , resultSet.getString("password")));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }


    /**TODO
    *  check duplicate account
    * */
    @Override
    public void createAccount(String login, String password) {
        Connection connection = getConnection();

        try (Connection connectionResource = isConnection ? null : connection;
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ACCOUNT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        Connection connection = getConnection();

        try (Connection connectionResource = isConnection ? null : connection;
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.setString(2, account.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Account account) {
        Connection connection = getConnection();

        try (Connection connectionResource = isConnection ? null : connection;
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setLong(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
