package controller.command;

import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequests implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        request.getSession().setAttribute(Constants.REQ_ID, null);
//        request.getSession().setAttribute(Constants.TOTAL_PRICE, null);

        return "forward:/WEB-INF/user/my_requests.jsp";
    }
}
