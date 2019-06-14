package controller.command;

import model.entity.Account;
import model.service.AccountService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

public class PayRequest implements Command {
    private AccountService accountService = new AccountService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter(Constants.REQ_ID);
        String totalPrice = request.getParameter(Constants.TOTAL_PRICE);

        if (id != null && totalPrice != null){
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            Account account = new Account();
            account.setRequestId(Integer.valueOf(id));
            account.setPaid(true);
            account.setDate(new java.sql.Date(date.getTime()));
            account.setAmount(Float.valueOf(totalPrice));
            accountService.createAccount(account);

            request.getSession().setAttribute(Constants.ACCOUNT, account);

        } else {
            return "forward:/WEB-INF/errors/forb.jsp";
        }

        return "forward:/WEB-INF/user/req_paid.jsp";
    }
}
