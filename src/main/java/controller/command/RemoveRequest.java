package controller.command;

import model.service.RequestService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveRequest implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id =  request.getParameter(Constants.REQ_ID);

        if (id != null)
            RequestService.removeRequest(Integer.valueOf(id));

        return "forward:/WEB-INF/user/my_requests.jsp";
    }
}
