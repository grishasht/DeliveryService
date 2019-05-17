package model.dao.mapper;

import model.entity.Account;

import java.sql.ResultSet;

public class AccountMapper implements Mapper<Account> {
    @Override
    public Account getEntityFromResSet(ResultSet resultSet, int... index) {
        return null;
    }
}
