package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseStreet implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String streetName = request.getParameter("street");
        request.getSession().setAttribute("street", streetName);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();


        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
