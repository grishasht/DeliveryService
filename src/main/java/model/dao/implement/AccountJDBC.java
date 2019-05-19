package model.dao.implement;

import model.dao.AccountDao;
import model.entity.Account;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class AccountJDBC implements AccountDao {
    private Logger log = LogGenerator.getInstance();
    private Properties prop = new Properties();
    private Connection connection;

    {
        try {
            prop.load(new FileInputStream("src/main/resources/log_msg.properties"));
        } catch (IOException e) {
            log.error(prop.getProperty("FILE_NOT_FOUND") + "in AccountJDBC");
        }
    }

    public AccountJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Account entity) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO accounts(APPLICATION_ID, AMOUNT, DATE, IS_PAID)" +
                "VALUES (?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(query);
            log.debug(prop.getProperty("PREP_STAT_OPEN") + "in AccountJDBC create");
            preparedStatement.setInt(entity.getApplicationId(), 1);
            preparedStatement.setInt(entity.getAmount(), 2);
            preparedStatement.setDate(3, entity.getDate());
            preparedStatement.setBoolean(4, entity.getPaid());
            preparedStatement.execute(query);
            log.debug(prop.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC create");
        } catch (SQLException e) {
            log.error(prop.getProperty("SQL_EXC_WHILE_CREATE") + "in AccountJDBC create");
        }finally {
            try {
                preparedStatement.close();
                log.debug(prop.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC create");
            } catch (SQLException e) {
                log.error(prop.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in AccountJDBC create");
            }
        }
    }

    @Override
    public List<Account> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Account> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Account entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM accounts WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(prop.getProperty("PREP_STAT_OPEN") + "in AccountJDBC deleting");
            preparedStatement.execute();
            log.debug(prop.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC deleting");
        } catch (SQLException e) {
            log.error(prop.getProperty("SQL_EXC_WHILE_DELETE") + "in AccountJDBC deleting");
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                log.error(prop.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in AccountJDBC deleting");
            }
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
            log.debug(prop.getProperty("CONN_CLOSE") + "in AccountJDBC");
        } catch (SQLException e) {
            log.error(prop.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in AccountJDBC");
        }
    }
}
