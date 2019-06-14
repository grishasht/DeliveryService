package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.entity.Account;

import java.sql.Date;
import java.util.List;

public class AccountService {
    private static DaoFactory daoFactory = DaoFactory.getInstance();
    private static AccountDao accountDao = daoFactory.createAccountDao();
    private static List<Account> accounts = accountDao.readAll();


    public void createAccount(Account account){
        accountDao.create(account);
    }

    public Account getAccount(Date date){
        return accounts.stream()
                .filter(account -> account.getDate().equals(date))
                .findAny()
                .get();
    }

}
