package model.dao.mapper;

import model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationMapper implements Mapper<Request> {
    @Override
    public Request getEntityFromResSet(ResultSet resultSet, int... index) {
        Request application = new Request();

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
