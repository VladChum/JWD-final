package com.epam.jwd_final.dao.impl;

import com.epam.jwd_final.dao.connection.ConnectionPool;
import com.epam.jwd_final.entity.TariffPlan;
import com.epam.jwd_final.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TariffPlanDaoImpl implements com.epam.jwd_final.dao.TariffPlanDao {
    private static final String GET_ALL_TARIFF = "select t.id, t.name, " +
            "t.price, t.discount_id, " +
            "t.speed " +
            "from tariff_plan t ";
    private static final String FIND_TARIFF_BY_ID = "select t.id, t.name, " +
            "t.price, t.discount_id, " +
            "t.speed " +
            "from tariff_plan t " +
            "where t.id = ?";
    private static final String CREATE_TARIFF = "insert into tariff_plan " +
            "(name, price, speed) " +
            "VALUES (?, ?, ?)";
    /**TODO
     * add update tariff price
     * add update tariff discount
     * */
    private static final String UPDATE_TARIFF = "update user set  where login = ?";
    /**ToDo
     * обработка удаления тарифа если его кто-то использует
     * */
    private static final String DELETE_TARIFF = "delete from tariff where id = ?";

    TariffPlanDaoImpl() {
    }

    @Override
    public List<TariffPlan> getAllTariff() throws DaoException {
        List<TariffPlan> tariffPlans = new ArrayList<TariffPlan>();

        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_TARIFF)) {
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    TariffPlan tariffPlan = new TariffPlan(resultSet.getLong("id"),
                            resultSet.getString(2),
                            resultSet.getBigDecimal(3),
                            resultSet.getLong(4),
                            resultSet.getInt(5));
                    tariffPlans.add(tariffPlan);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return tariffPlans;
    }

    @Override
    public Optional<TariffPlan> findTariffById(int tariffId) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_TARIFF_BY_ID)) {
            prepareStatement.setInt(1, tariffId);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new TariffPlan(resultSet.getLong("id"),
                            resultSet.getString(2),
                            resultSet.getBigDecimal(3),
                            resultSet.getLong(4),
                            resultSet.getInt(5)));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return Optional.empty();
    }

    @Override
    public void createTariff(TariffPlan tariffPlan) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TARIFF)) {
            preparedStatement.setString(1, tariffPlan.getName());
            preparedStatement.setBigDecimal(2, tariffPlan.getPrice());
            preparedStatement.setInt(3, tariffPlan.getSpeed());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateTariff(TariffPlan tariffPlan) {

    }

    @Override
    public void deleteTariff(TariffPlan tariffPlan) throws DaoException {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TARIFF)) {
            preparedStatement.setLong(1, tariffPlan.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
