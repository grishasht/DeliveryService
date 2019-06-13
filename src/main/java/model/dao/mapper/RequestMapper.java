package model.dao.mapper;

import model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestMapper implements Mapper<Request> {
    @Override
    public Request getEntityFromResSet(ResultSet resultSet, int... index) {
        Request request = new Request();

        try {
            request.setId(resultSet.getInt(index[0]));
            request.setUserId(resultSet.getInt(index[1]));
            request.setLuggageId(resultSet.getInt(index[2]));
            request.setAddressId(resultSet.getInt(index[3]));
            request.setSendDate(resultSet.getDate(index[4]));
            request.setReceiveDate(resultSet.getDate(index[5]));
            request.setWeight(resultSet.getFloat(index[6]));
            request.setPrice(resultSet.getFloat(index[7]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;
    }
}
