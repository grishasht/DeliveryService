package controller.command;

import model.entity.User;
import model.service.LuggageService;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChooseLuggage implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lugType = request.getParameter(Constants.LUG_TYPE);
        request.getSession().setAttribute(Constants.LUG_TYPE, lugType);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        log.info("Luggage type was chosen");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
