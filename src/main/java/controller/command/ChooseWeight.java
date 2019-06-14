package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseWeight implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lugWeight = request.getParameter(Constants.LUG_WEIGHT);
        request.getSession().setAttribute(Constants.LUG_WEIGHT, lugWeight);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        log.info("Weight was chosen");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
