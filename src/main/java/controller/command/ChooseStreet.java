package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseStreet implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String streetName = request.getParameter(Constants.STREET_NAME);
        request.getSession().setAttribute(Constants.STREET_NAME, streetName);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        log.info("Street was chosen");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
