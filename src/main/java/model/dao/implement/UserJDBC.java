package model.dao.implement;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserJDBC extends JDBC implements UserDao {
    public UserJDBC(Connection connection) {
        super(connection);
    }

    @Override
    public void create(User entity) {
        final String QUERY = "INSERT INTO users(login, password, name, email, role) " +
                " VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            System.out.println(connection.toString());
            log.info(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC creating");

            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.execute();

            log.info(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in UserJDBC creating");
            log.info(properties.getProperty("PREP_STAT_CLOSE") + "in UserJDBC creating");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in UserJDBC creating");
        }

    }

    @Override
    public List<User> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> readAll() {
        List<User> users = new LinkedList<>();
        final String QUERY = "SELECT * FROM users";
        UserMapper userMapper = new UserMapper();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC readAll");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                log.debug(properties.getProperty("RES_SET_OPEN") + "in UserJDBC readAll");

                while (resultSet.next()) {
                    users.add(userMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6));
                }
                log.debug(properties.getProperty("RES_SET_CLOSE") + "in UserJDBC");
            }
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in UserJDBC readAll");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in UserJDBC");
        }

        return users;
    }

    @Override
    public void update(Integer id, User entity) {
        //Realize later
    }

    @Override
    public void delete(Integer id) {
        final String QUERY = "DELETE FROM users WHERE id = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC deleting");

            preparedStatement.execute();

            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in UserJDBC deleting");
            log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in RequestJDBC deleting");

        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in UserJDBC");
        }

    }

    @Override
    public void close() {
        try {
            connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in UserJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in UserJDBC");
        }
    }
}
