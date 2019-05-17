package model.dao.implement;

import model.dao.UserDao;
import model.entity.User;

import java.util.List;

public class UserJDBC implements UserDao {
    @Override
    public void create(User entity) {

    }

    @Override
    public List<User> read(Integer id) {
        return null;
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void close() throws Exception {

    }
}
