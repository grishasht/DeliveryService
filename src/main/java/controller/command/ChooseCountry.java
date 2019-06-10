package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseCountry implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String countryName = request.getParameter("country");
        request.getSession().setAttribute("country", countryName);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();


        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
