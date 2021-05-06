package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.UserDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Status;
import com.epam.jwd_final.entity.User;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final String FIND_USER_BY_ID = "select u.id, u.account_id, " +
            "u.first_name, u.last_name, " +
            "u.phone, u.email, " +
            "u.balance, u.status_id_fk " +
            "from user u " +
            "inner join account a on a.id = u.account_id " +
            "inner join user_status s on  s.id = u.status_id_fk " +
            "where u.id = ?";
    private static final String FIND_USER_BY_ACCOUNT_ID = "select u.id, u.account_id, " +
            "u.first_name, u.last_name, " +
            "u.phone, u.email, " +
            "u.balance, u.status_id_fk " +
            "from user u " +
            "inner join account a on a.id = u.account_id " +
            "inner join user_status s on  s.id = u.status_id_fk " +
            "where u.account_id = ?";
    private static final String GET_ALL_USER = "select u.id, u.account_id, " +
            "u.first_name, u.last_name, " +
            "u.phone, u.email, " +
            "u.balance, u.status_id_fk " +
            "from user u " +
            "inner join account a on a.id = u.account_id " +
            "inner join user_status s on  s.id = u.status_id_fk";
    private static final String CREATE_USER = "insert into user " +
            "(account_id, first_name, last_name, phone, email, status_id_fk) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    /***TODO
     * update user status
     * */
    private static final String UPDATE_USER = "update user set  where login = ?";
    private static final String DELETE_USER = "delete from user where id = ?";

    UserDaoImpl() {
    }



    @Override
    public List<User> getAllUser() throws DaoException {
        List<User> users = new ArrayList<User>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_USER)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User(resultSet.getLong("id")
                            , resultSet.getLong(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5)
                            , resultSet.getString(6)
                            , Status.resolveStatusById(resultSet.getInt(8)),
                            resultSet.getBigDecimal(7));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findUserById(int userId) throws DaoException {

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_USER_BY_ID)) {
            prepareStatement.setInt(1, userId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new User(resultSet.getLong("id")
                            , resultSet.getLong(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5)
                            , resultSet.getString(6)
                            , Status.resolveStatusById(resultSet.getInt(8)),
                            resultSet.getBigDecimal(7)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByAccountId(int userId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_USER_BY_ACCOUNT_ID)) {
            prepareStatement.setInt(1, userId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new User(resultSet.getLong("id")
                            , resultSet.getLong(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5)
                            , resultSet.getString(6)
                            , Status.resolveStatusById(resultSet.getInt(8)),
                            resultSet.getBigDecimal(7)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {
            preparedStatement.setInt(1, user.getAccountId().intValue());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getStatus().getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public void deleteUser(User user) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateUserStatus(Status status) {

    }
}
