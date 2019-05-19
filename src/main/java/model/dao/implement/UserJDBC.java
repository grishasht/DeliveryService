package model.dao.implement;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;
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

public class UserJDBC implements UserDao {
    private Logger log = LogGenerator.getInstance();
    private Properties properties = new Properties();
    private Connection connection;

    {
        try {
            properties.load(new FileInputStream("src/main/resources/log_msg.properties"));
        } catch (IOException e) {
            log.error(properties.getProperty("FILE_NOT_FOUND") + "in UserJDBC");
        }
    }

    public UserJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        String query = "INSERT INTO users(login, password, name, email, role) " +
                " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC creating");
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in UserJDBC creating");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in UserJDBC creating");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    log.error(properties.getProperty("PREP_STAT_CLOSE") + "in UserJDBC creating");
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CREATE") + "in UserJDBC creating");
                }
            }
        }
    }

    @Override
    public List<User> read(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> readAll() {
        List<User> users = new LinkedList<>();
        String query = "SELECT * FROM users";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserMapper userMapper = new UserMapper();

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC readAll");
            resultSet = preparedStatement.executeQuery();
            log.debug(properties.getProperty("RES_SET_OPEN") + "in UserJDBC readAll");

            while (resultSet.next()) {
                users.add(userMapper.getEntityFromResSet(resultSet, 1, 2, 3, 4, 5, 6));
            }
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_READ") + "in UserJDBC");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    log.debug(properties.getProperty("RES_SET_CLOSE") + "in UserJDBC");
                }
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                        log.debug(properties.getProperty("PREP_STAT_CLOSE") + "in UserJDBC readAll");
                    }
                } catch (SQLException e) {
                    log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in UserJDBC readAll");
                }
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_RES_SET") + "in UserJDBC readAll");
            }
        }
        return users;
    }

    @Override
    public void update(Integer id, User entity) {
    //Realize later
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM users WHERE id = " + id;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            log.debug(properties.getProperty("PREP_STAT_OPEN") + "in UserJDBC deleting");
            preparedStatement.execute();
            log.debug(properties.getProperty("SUCCESS_QUERY_EXECUTE") + "in UserJDBC deleting");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_DELETE") + "in UserJDBC");
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_PREP") + "in UserJDBC deleting");
            }
        }
    }

    @Override
    public void close(){
        try {
            connection.close();
            log.debug(properties.getProperty("CONN_CLOSE") + "in UserJDBC");
        } catch (SQLException e) {
            log.error(properties.getProperty("SQL_EXC_WHILE_CLOSE_CONN") + "in UserJDBC");
        }
    }
}
