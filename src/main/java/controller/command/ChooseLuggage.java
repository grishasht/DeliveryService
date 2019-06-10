package controller.command;

import model.entity.User;
import model.service.LuggageService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChooseLuggage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lugType = request.getParameter(Constants.LUG_TYPE);
        request.getSession().setAttribute(Constants.LUG_TYPE, lugType);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
