package model.dao.mapper;

import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User getEntityFromResSet(ResultSet resultSet, int... index) {
        User user = new User();

        try {
            user.setId(resultSet.getInt(index[0]));
            user.setEmail(resultSet.getString(index[1]));
            user.setName(resultSet.getString(index[2]));
            user.setLogin(resultSet.getString(index[3]));
            user.setPassword(resultSet.getString(index[4]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
