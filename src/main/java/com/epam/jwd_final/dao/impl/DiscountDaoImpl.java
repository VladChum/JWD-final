package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.DiscountDao;
import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.Discount;
import com.epam.jwd_final.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscountDaoImpl implements DiscountDao {
    private static final String FIND_DISCOUNT_BY_ID = "select d.id, d.size, d.start_date, d.end_date from discount d where id = ?";
    private static final String FIND_ALL_DISCOUNT = "select d.id, d.size, d.start_date, d.end_date from discount d";
    private static final String CREATE_DISCOUNT = "insert into discount (size, start_date, end_date) VALUES (?, ?, ?)";
    private static final String UPDATE_DISCOUNT = "update discount d set d.size = ?, d.start_date = ?, d.end_date = ? where id = ?";
    private static final String ACTIVATE_DISCOUNT = "";
    private static final String STOP_DISCOUNT = "update discount set end_date = ? where id = ?";

    DiscountDaoImpl() {
    }

    @Override
    public void create(Discount discount) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DISCOUNT)) {
            preparedStatement.setDouble(1, discount.getSize());
            preparedStatement.setDate(2, Date.valueOf(String.valueOf(discount.getStartDate())));
            preparedStatement.setDate(3, Date.valueOf(String.valueOf(discount.getEndDate())));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Discount> findAll() throws DaoException {
        List<Discount> discounts = new ArrayList<Discount>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_DISCOUNT)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Discount discount = new Discount(
                            resultSet.getLong("id"),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getDouble(2));
                    discounts.add(discount);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return discounts;
    }

    @Override
    public Optional<Discount> findById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_DISCOUNT_BY_ID)) {

            prepareStatement.setInt(1, id.intValue());
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Discount(
                            resultSet.getLong("id"),
                            resultSet.getDate(3),
                            resultSet.getDate(4),
                            resultSet.getDouble(2)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public void stopDiscount(Discount discount) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(STOP_DISCOUNT)) {
            preparedStatement.setDate(1, Date.valueOf(String.valueOf(discount.getEndDate())));
            preparedStatement.setInt(2, discount.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void activateDiscount(Discount discount) throws DaoException {

    }

    @Override
    public void updateDiscount(Discount discount) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DISCOUNT)) {
            preparedStatement.setDouble(1, discount.getSize());
            preparedStatement.setDate(2, Date.valueOf(String.valueOf(discount.getStartDate())));
            preparedStatement.setDate(3, Date.valueOf(String.valueOf(discount.getEndDate())));
            preparedStatement.setInt(4, discount.getId().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
