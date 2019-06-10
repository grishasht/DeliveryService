package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestAdd implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
