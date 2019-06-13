package model.dao.implement;

import model.dao.RequestDao;
import model.dao.mapper.RequestMapper;
import model.entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RequestJDBC extends JDBC implements RequestDao {
    public RequestJDBC(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Request entity) {
        final String QUERY = "INSERT INTO requests(user_id, luggage_id, address_id, " +
                "send_date, receive_date, weight, house, price) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC creating");

            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getLuggageId());
            preparedStatement.setInt(3, entity.getAddressId());
            preparedStatement.setDate(4, entity.getSendDate());
            preparedStatement.setDate(5, entity.getReceiveDate());
            preparedStatement.setFloat(6, entity.getWeight());
            preparedStatement.setInt(7, entity.getHouseNum());
            preparedStatement.setFloat(8, entity.getPrice());
            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC creating");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC creating");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in RequestJDBC creating");
        }
    }

    @Override
    public List<Request> read(Integer id) {
        List<Request> requests = new LinkedList<>();
        final String QUERY = "SELECT * FROM requests WHERE user_id = " + id;
        RequestMapper requestMapper = new RequestMapper();

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC read");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in RequestJDBC read");

                while (resultSet.next()) {
                    requests.add(requestMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6, 7, 8));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in RequestJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC read");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in RequestJDBC");
        }

        return requests;
    }

    @Override
    public List<Request> readAll() {
        List<Request> addresses = new LinkedList<>();
        final String QUERY = "SELECT * FROM requests";
        RequestMapper requestMapper = new RequestMapper();

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC readAll");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in RequestJDBC readAll");

                while (resultSet.next()) {
                    addresses.add(requestMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6, 7, 8));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in RequestJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC readAll");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in RequestJDBC");
        }

        return addresses;
    }

    @Override
    public void update(Integer id, Request entity) {
        final String QUERY = "UPDATE requests SET user_id = ?, luggage_id = ?, " +
                "address_id = ?, send_date = ?, receive_date = ?, weight = ?" +
                "WHERE id = " + id;

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC update");

            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getLuggageId());
            preparedStatement.setInt(3, entity.getAddressId());
            preparedStatement.setDate(4, entity.getSendDate());
            preparedStatement.setDate(5, entity.getReceiveDate());
            preparedStatement.setFloat(6, entity.getWeight());
            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC update");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC update");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_UPDATE") + "in RequestJDBC");
        }

    }

    @Override
    public void delete(Integer id) {
        final String QUERY = "DELETE FROM requests WHERE id = " + id;

        try (PreparedStatement preparedStatement =connection.prepareStatement(QUERY)){

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC deleting");

            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC deleting");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC deleting");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in RequestJDBC");
        }

    }

    @Override
    public void close() {
        try {
            connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in RequestJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in RequestJDBC");
        }
    }
}
