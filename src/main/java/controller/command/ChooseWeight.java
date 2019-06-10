package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseWeight implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lugWeight = request.getParameter(Constants.LUG_WEIGHT);
        request.getSession().setAttribute(Constants.LUG_WEIGHT, lugWeight);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();


        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
