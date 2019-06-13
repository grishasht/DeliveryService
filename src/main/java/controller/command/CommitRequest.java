package controller.command;

import model.entity.User;
import model.service.RequestService;
import model.util.Constants;
import model.util.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommitRequest implements Command {
    RequestService requestService = new RequestService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        String role = user.getRole().getValue();

        if (role.equals(Role.GUEST.getValue())){
            return "forward:/WEB-INF/errors/reg_required.jsp";
        } else {
            requestService.createRequest(request, user);
            ResetFields resetFields = new ResetFields();
            resetFields.execute(request, response);
            return "forward:/WEB-INF/" + role + "/success.jsp";
        }
    }
}
