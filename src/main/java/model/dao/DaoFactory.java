package model.dao;

import model.dao.implement.FactoryJDBC;

public abstract class DaoFactory {

    public abstract AccountDao createAccountDao();

    public abstract AddressDao createAddressDao();

    public abstract RequestDao createRequestDao();

    public abstract LuggageDao createLuggageDao();

    public abstract UserDao createUserDao();

    private static class SingletonHolder {
        public static final DaoFactory INSTANCE = new FactoryJDBC();
    }

    public static DaoFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
