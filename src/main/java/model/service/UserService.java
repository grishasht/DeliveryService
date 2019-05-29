package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entity.User;

public class UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void registerUser(User user){
        UserDao userDao = daoFactory.createUserDao();
        userDao.create(user);
    }
}
