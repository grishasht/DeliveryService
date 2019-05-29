package model.dao.implement;

import model.dao.*;

import java.sql.Connection;
import java.sql.SQLException;

public class FactoryJDBC extends DaoFactory {

    @Override
    public AccountDao createAccountDao() {
        AccountDao accountDao = new AccountJDBC(getConnection());
        return accountDao;
    }

    @Override
    public AddressDao createAddressDao() {
        AddressDao addressDao = new AddressJDBC(getConnection());
        return addressDao;
    }

    @Override
    public RequestDao createRequestDao() {
        RequestDao requestDao = new RequestJDBC(getConnection());
        return requestDao;
    }

    @Override
    public LuggageDao createLuggageDao() {
        LuggageDao luggageDao = new LuggageJDBC(getConnection());
        return luggageDao;
    }

    @Override
    public UserDao createUserDao() {
        UserDao userDao = new UserJDBC(getConnection());
        return userDao;
    }

    private Connection getConnection(){
        try {
            return ConnectionPool.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
