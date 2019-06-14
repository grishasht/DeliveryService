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
            request.setCountry(resultSet.getString(index[1]));
            request.setCity(resultSet.getString(index[2]));
            request.setStreet(resultSet.getString(index[3]));
            request.setHouseNum(resultSet.getInt(index[4]));
            request.setLuggage(resultSet.getString(index[5]));
            request.setPrice(resultSet.getFloat(index[6]));
            request.setSendDate(resultSet.getDate(index[7]));
            request.setReceiveDate(resultSet.getDate(index[8]));
            request.setWeight(resultSet.getFloat(index[9]));
            request.setTotalPrice(resultSet.getFloat(index[10]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;
    }
}
