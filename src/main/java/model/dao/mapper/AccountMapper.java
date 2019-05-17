package model.dao.mapper;

import model.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements Mapper<Account> {
    @Override
    public Account getEntityFromResSet(ResultSet resultSet, int... index) {
        Account account = new Account();

        try {
            account.setId(resultSet.getInt(index[0]));
            account.setAmount(resultSet.getInt(index[1]));
            account.setDate(resultSet.getDate(index[2]));
            account.setPaid(resultSet.getBoolean(index[3]));
            account.setApplicationId(resultSet.getInt(index[4]));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
