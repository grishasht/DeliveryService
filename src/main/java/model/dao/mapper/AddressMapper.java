package model.dao.mapper;

import model.entity.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements Mapper<Address> {
    @Override
    public Address getEntityFromResSet(ResultSet resultSet, int... index) {
        Address address = new Address();

        try {
            address.setId(resultSet.getInt(index[0]));
            address.setCountry(resultSet.getString(index[1]));
            address.setCity(resultSet.getString(index[2]));
            address.setStreet(resultSet.getString(index[3]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }
}
