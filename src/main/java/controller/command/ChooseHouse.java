package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseHouse implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String houseNum = request.getParameter(Constants.HOUSE_NUM);
        request.getSession().setAttribute(Constants.HOUSE_NUM, houseNum);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        log.info("House chosen");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
