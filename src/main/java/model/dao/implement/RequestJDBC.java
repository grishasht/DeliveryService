package model.dao.implement;

import model.dao.ApplicationDao;
import model.entity.Application;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ApplicationJDBC implements ApplicationDao {
    private Logger log = LogGenerator.getInstance();
    private Properties properties = new Properties();
    private Connection connection;

    {
        try {
            properties.load(new FileInputStream("src/main/resources/log_msg.properties"));
        } catch (IOException e) {
            log.error(properties.getProperty("FILE_NOT_FOUND") + "in AccountJDBC");
        }
    }

    @Override
    public void create(Application entity) {
        String query = "INSERT INTO addresses(country, city, street, house) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AccountJDBC creating");
            preparedStatement.setString(1, entity.getCountry());
            preparedStatement.setString(2, entity.getCity());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.setInt(4, entity.getHouse());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC creating");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in AccountJDBC creating");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    log.error(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC creating");
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in AccountJDBC creating");
                }
            }
        }
    }

    @Override
    public List<Application> read(Integer id) {
        return null;
    }

    @Override
    public List<Application> readAll() {
        return null;
    }

    @Override
    public void update(Integer id, Application entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void close(){

    }
}
