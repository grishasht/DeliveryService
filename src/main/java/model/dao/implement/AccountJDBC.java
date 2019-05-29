package model.dao.implement;

import model.dao.AccountDao;
import model.dao.mapper.AccountMapper;
import model.entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AccountJDBC extends JDBC implements AccountDao {
    public AccountJDBC(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Account entity) {
        final String QUERY = "INSERT INTO accounts(APPLICATION_ID, AMOUNT, DATE, IS_PAID)" +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AccountJDBC create");

            preparedStatement.setInt(1, entity.getApplicationId());
            preparedStatement.setInt(2, entity.getAmount());
            preparedStatement.setDate(3, entity.getDate());
            preparedStatement.setBoolean(4, entity.getPaid());

            preparedStatement.execute(QUERY);
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC create");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC create");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in AccountJDBC");
        }
    }

    @Override
    public List<Account> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Account> readAll() {
        List<Account> accounts = new LinkedList<>();
        final String QUERY = "SELECT * FROM addresses";
        AccountMapper accountMapper = new AccountMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AccountJDBC readAll");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in AccountJDBC readAll");

                while (resultSet.next()) {
                    accounts.add(accountMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in AccountJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC readAll");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in AccountJDBC");
        }

        return accounts;
    }

    @Override
    public void update(Integer id, Account entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        final String QUERY = "DELETE FROM accounts WHERE id = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AccountJDBC deleting");
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC deleting");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC deleting");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in AccountJDBC");
        }

    }

    @Override
    public void close() {
        try {
            if (connection != null)
                connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in AccountJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in AccountJDBC");
        }
    }
}
