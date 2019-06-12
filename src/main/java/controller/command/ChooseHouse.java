package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseHouse implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String houseNum = request.getParameter(Constants.HOUSE_NUM);
        request.getSession().setAttribute(Constants.HOUSE_NUM, houseNum);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();


        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
