package model.dao.implement;

import model.dao.ApplicationDao;
import model.dao.mapper.RequestMapper;
import model.entity.Request;
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

public class RequestJDBC implements ApplicationDao {
    private Logger log = LogGenerator.getInstance();
    private Properties properties = new Properties();
    private Connection connection;

    {
        try {
            properties.load(new FileInputStream("src/main/resources/log_msg.properties"));
        } catch (IOException e) {
            log.error(properties.getProperty("FILE_NOT_FOUND") + "in RequestJDBC");
        }
    }

    public RequestJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Request entity) {
        String query = "INSERT INTO requests(user_id, luggage_id, address_id, send_date, receive_date) " +
                " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC creating");
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getLuggageId());
            preparedStatement.setInt(3, entity.getAddressId());
            preparedStatement.setDate(4, entity.getSendDate());
            preparedStatement.setDate(5, entity.getReceiveDate());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC creating");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in RequestJDBC creating");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    log.error(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC creating");
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in RequestJDBC creating");
                }
            }
        }
    }

    @Override
    public List<Request> read(Integer id) {
        List<Request> requests = new LinkedList<>();
        String query = "SELECT * FROM requests WHERE id = " + id;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RequestMapper requestMapper = new RequestMapper();

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC reading");
            resultSet = preparedStatement.executeQuery();
            log.debug(properties.getProperty("RES_SET_OPEN") + "in RequestJDBC reading");

            while (resultSet.next()) {
                requests.add(requestMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6));
            }
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in RequestJDBC");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    log.debug(properties.getProperty("RES_SET_CLOSE") + "in RequestJDBC");
                }
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                        log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC read");
                    }
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in RequestJDBC read");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_RES_SET") + "in RequestJDBC read");
            }
        }

        return requests;
    }

    @Override
    public List<Request> readAll() {
        List<Request> addresses = new LinkedList<>();
        String query = "SELECT * FROM requests";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RequestMapper requestMapper = new RequestMapper();

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC readAll");
            resultSet = preparedStatement.executeQuery();
            log.debug(properties.getProperty("RES_SET_OPEN") + "in RequestJDBC readAll");

            while (resultSet.next()) {
                addresses.add(requestMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6));
            }
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in RequestJDBC");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    log.debug(properties.getProperty("RES_SET_CLOSE") + "in RequestJDBC");
                }
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                        log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC readAll");
                    }
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in RequestJDBC readAll");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_RES_SET") + "in RequestJDBC readAll");
            }
        }

        return addresses;
    }

    @Override
    public void update(Integer id, Request entity) {
        String query = "UPDATE requests SET user_id = ?, luggage_id = ?, " +
                "address_id = ?, send_date = ?, receive_date = ?" +
                "WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC update");
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getLuggageId());
            preparedStatement.setInt(3, entity.getAddressId());
            preparedStatement.setDate(4, entity.getSendDate());
            preparedStatement.setDate(5, entity.getReceiveDate());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC update");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_UPDATE") + "in RequestJDBC");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    log.error(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC update");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in RequestJDBC updating");
            }
        }
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM requests WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in RequestJDBC deleting");
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in RequestJDBC deleting");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in RequestJDBC");
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in RequestJDBC deleting");
            }
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
