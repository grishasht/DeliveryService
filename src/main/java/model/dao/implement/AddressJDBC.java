package model.dao.implement;

import model.dao.AddressDao;
import model.dao.mapper.AddressMapper;
import model.entity.Address;
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

public class AddressJDBC implements AddressDao {
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

    public AddressJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Address entity) {
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
    public List<Address> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Address> readAll() {
        List<Address> addresses = new LinkedList<>();
        String query = "SELECT * FROM addresses";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AddressMapper addressMapper = new AddressMapper();

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AccountJDBC readingAll");
            resultSet = preparedStatement.executeQuery();
            log.debug(properties.getProperty("RES_SET_OPEN") + "in AccountJDBC readingAll");

            while (resultSet.next()) {
                addresses.add(addressMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5));
            }
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in AccountJDBC");
        } finally {
            try {
                resultSet.close();
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in AccountJDBC");
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                        log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC readAll");
                    }
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in AccountJDBC readAll");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_RES_SET") + "in AccountJDBC readAll");
            }
        }

        return addresses;
    }

    @Override
    public void update(Integer id, Address entity) {
        String query = "UPDATE addresses SET country = ?, city = ?, street = ?, house = ?" +
                "WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressesJDBC update");
            preparedStatement.setString(1, entity.getCountry());
            preparedStatement.setString(2, entity.getCity());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.setInt(4, entity.getHouse());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AccountJDBC update");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_UPDATE") + "in AddressesJDBC");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    log.error(properties.getProperty("PREP_STAT_CLOSE") + "in AccountJDBC update");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in AddressesJDBC updating");
            }
        }
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM addresses WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressesJDBC deleting");
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AddressesJDBC deleting");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in AddressesJDBC");
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in AddressesJDBC deleting");
            }
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in AddressJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in AddressJDBC");
        }
    }
}
