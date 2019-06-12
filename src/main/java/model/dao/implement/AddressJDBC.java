package model.dao.implement;

import model.dao.AddressDao;
import model.dao.mapper.AddressMapper;
import model.entity.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AddressJDBC extends JDBC implements AddressDao {
    public AddressJDBC(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Address entity) {
        final String QUERY = "INSERT INTO countries(country, city, street) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressJDBC creating");
            preparedStatement.setString(1, entity.getCountry());
            preparedStatement.setString(2, entity.getCity());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AddressJDBC creating");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AddressJDBC creating");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in AddressJDBC creating");
        }

    }

    @Override
    public List<Address> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Address> readAll() {
        List<Address> addresses = new LinkedList<>();
        final String QUERY = "SELECT * FROM addresses";
        AddressMapper addressMapper = new AddressMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressJDBC readAll");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in AddressJDBC readAll");

                while (resultSet.next()) {
                    addresses.add(addressMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in AddressJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AddressJDBC readAll");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in AddressJDBC");
        }

        return addresses;
    }

    @Override
    public void update(Integer id, Address entity) {
        final String QUERY = "UPDATE countries SET country = ?, city = ?, street = ?" +
                "WHERE id = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressJDBC update");

            preparedStatement.setString(1, entity.getCountry());
            preparedStatement.setString(2, entity.getCity());
            preparedStatement.setString(3, entity.getStreet());
            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AddressJDBC update");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AddressJDBC update");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_UPDATE") + "in AddressJDBC");
        }
    }

    @Override
    public void delete(Integer id) {
        final String QUERY = "DELETE FROM countries WHERE id = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in AddressJDBC deleting");

            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in AddressJDBC deleting");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in AddressJDBC deleting");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in AddressJDBC");
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
