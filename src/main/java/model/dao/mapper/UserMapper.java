package model.dao.mapper;

import model.entity.User;

import java.sql.ResultSet;

public class UserMapper implements Mapper<User> {
    @Override
    public User getEntityFromResSet(ResultSet resultSet, int... index) {
        return null;
    }
}
