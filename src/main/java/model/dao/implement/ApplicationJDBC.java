package model.dao.implement;

import model.dao.ApplicationDao;
import model.entity.Application;

import java.util.List;

public class ApplicationJDBC implements ApplicationDao {
    @Override
    public void create(Application entity) {

    }

    @Override
    public List<Application> read(Integer id) {
        return null;
    }

    @Override
    public List<Application> readAll() {
        return null;
    }

    @Override
    public void update(Application entity) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void close() throws Exception {

    }
}
