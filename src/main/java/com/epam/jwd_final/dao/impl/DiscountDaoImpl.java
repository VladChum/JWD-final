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
    private static final String UPDATE_DISCOUNT = "update account set password = ? where login = ?";
    private static final String DELETE_DISCOUNT = "delete from account where id = ?";

    DiscountDaoImpl() {
    }

    @Override
    public void create(Discount discount) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DISCOUNT)) {
            preparedStatement.setDouble(1, discount.getSize());
            preparedStatement.setDate(2, (Date) discount.getStartDate());
            preparedStatement.setDate(3, (Date) discount.getEndDate());
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
                            resultSet.getDate(2),
                            resultSet.getDate(3),
                            resultSet.getDouble(4)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();    }

    @Override
    public void stopDiscount() throws DaoException {

    }

    @Override
    public void activateDiscount(Discount discount) throws DaoException {

    }
}
