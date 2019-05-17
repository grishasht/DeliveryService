package model.dao.implement;

import model.dao.AccountDao;
import model.entity.Account;

import java.util.List;

public class AccountJDBC implements AccountDao {
    @Override
    public void create(Account entity) {

    }

    @Override
    public List<Account> read(Integer id) {
        return null;
    }

    @Override
    public List<Account> readAll() {
        return null;
    }

    @Override
    public void update(Account entity) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void close() throws Exception {

    }
}
