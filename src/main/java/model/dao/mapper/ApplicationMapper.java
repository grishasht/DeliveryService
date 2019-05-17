package model.dao.mapper;

import model.entity.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationMapper implements Mapper<Application> {
    @Override
    public Application getEntityFromResSet(ResultSet resultSet, int... index) {
        Application application = new Application();

        try {
            application.setId(resultSet.getInt(index[0]));
            application.setUserId(resultSet.getInt(index[1]));
            application.setLuggageId(resultSet.getInt(index[2]));
            application.setAddressId(resultSet.getInt(index[3]));
            application.setSendDate(resultSet.getDate(index[4]));
            application.setReceiveDate(resultSet.getDate(index[5]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return application;
    }
}
