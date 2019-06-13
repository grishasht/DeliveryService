package model.dao.mapper;

import model.entity.Luggage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LuggageMapper implements Mapper<Luggage> {
    @Override
    public Luggage getEntityFromResSet(ResultSet resultSet, int... index) {
        Luggage luggage = new Luggage();

        try {
            luggage.setId(resultSet.getInt(index[0]));
            luggage.setType(resultSet.getString(index[1]));
            luggage.setPrice(resultSet.getFloat(index[2]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return luggage;
    }
}
