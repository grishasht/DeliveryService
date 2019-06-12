package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommitRequest implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();

        if (role.equals(Role.GUEST.getValue())){
            return "forward:/WEB-INF/errors/reg_required.jsp";
        } else {
            return "forward:/WEB-INF/" + role + "/service.jsp";
        }
    }
}
