package model.dao.implement;

import model.dao.LuggageDao;
import model.dao.mapper.LuggageMapper;
import model.entity.Luggage;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class LuggageJDBC implements LuggageDao {
    private Logger log = LogGenerator.getInstance();
    private Properties properties = new Properties();
    private Connection connection;

    {
        try {
            properties.load(new FileInputStream("src/main/resources/log_msg.properties"));
        } catch (IOException e) {
            log.error(properties.getProperty("FILE_NOT_FOUND") + "in LuggageJDBC");
        }
    }

    public LuggageJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Luggage entity) {
        final String QUERY = "INSERT INTO luggage(type, weight, price)" +
                "VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in LuggageJDBC creating");
            preparedStatement.setString(1, entity.getType());
            preparedStatement.setFloat(2, entity.getWeight());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in LuggageJDBC creating");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in LuggageJDBC creating");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in LuggageJDBC creating");
        }
    }

    @Override
    public List<Luggage> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Luggage> readAll() {
        List<Luggage> luggage = new LinkedList<>();

        final String QUERY = "SELECT * FROM luggage";
        LuggageMapper luggageMapper = new LuggageMapper();

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in LuggageJDBC readingAll");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in LuggageJDBC readingAll");

                while (resultSet.next()) {
                    luggage.add(luggageMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in LuggageJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in LuggageJDBC readAll");

        } catch(SQLException e){
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in LuggageJDBC");
        }

        return luggage;
    }

    @Override
    public void update(Integer id, Luggage entity) {
        final String QUERY = "UPDATE luggage SET type = ?, weight = ?, price = ?" +
                "WHERE id = " + id;

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in LuggageJDBC update");
            preparedStatement.setString(1, entity.getType());
            preparedStatement.setFloat(2, entity.getWeight());
            preparedStatement.setFloat(3, entity.getPrice());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in LuggageJDBC update");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in LuggageJDBC update");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_UPDATE") + "in LuggageJDBC");
        }

    }

    @Override
    public void delete(Integer id) {
        final String QUERY = "DELETE FROM luggage WHERE id = " + id;

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in LuggageJDBC deleting");
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in LuggageJDBC deleting");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in LuggageJDBC delete");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in LuggageJDBC");
        }

    }

    @Override
    public void close() {
        try {
            connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in LuggageJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in LuggageJDBC");
        }
    }
}
