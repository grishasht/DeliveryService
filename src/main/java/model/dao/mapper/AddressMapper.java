package model.dao.mapper;

import model.entity.Address;

import java.sql.ResultSet;

public class AddressMapper implements Mapper<Address> {
    @Override
    public Address getEntityFromResSet(ResultSet resultSet, int... index) {
        return null;
    }
}
