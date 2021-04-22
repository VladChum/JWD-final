package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.AccountDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Account;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    private final Connection transactionConnection;
    private final boolean isConnection;

    private static final String FIND_ACCOUNT_BY_ID = "select a.id, a.login, a.password from account a inner where a.id ?";
    private static final String CREATE_ACCOUNT = "insert into account (login, password) VALUES (?, ?)";
    private static final String UPDATE_ACCOUNT = "update account set login = ?, password = ?";
    private static final String DELETE_ACCOUNT = "";

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
    public Optional<Account> findAccountById(int accountId) throws DaoException {
        Connection connection = getConnection();

        try (Connection connectionResource = isConnection ? null : connection;
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ACCOUNT_BY_ID)) {

            prepareStatement.setInt(1, accountId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                Optional<Account> accountOptional = Optional.empty();
                if (resultSet.next()) {
                    Account account = new Account(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
                    accountOptional = Optional.of(account);
                }
                return accountOptional;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Account account) {

    }
}
