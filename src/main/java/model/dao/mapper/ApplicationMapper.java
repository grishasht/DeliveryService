package model.dao.mapper;

import model.entity.Application;

import java.sql.ResultSet;

public class ApplicationMapper implements Mapper<Application> {
    @Override
    public Application getEntityFromResSet(ResultSet resultSet, int... index) {
        return null;
    }
}
