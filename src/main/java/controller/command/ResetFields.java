package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetFields implements Command {
    private Logger log = LogGenerator.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();

        if (request.getSession().getAttribute(Constants.COUNTRY_NAME) != null)
            request.getSession().removeAttribute(Constants.COUNTRY_NAME);

        if (request.getSession().getAttribute(Constants.CITY_NAME) != null)
            request.getSession().removeAttribute(Constants.CITY_NAME);

        if (request.getSession().getAttribute(Constants.STREET_NAME) != null)
            request.getSession().removeAttribute(Constants.STREET_NAME);

        if (request.getSession().getAttribute(Constants.HOUSE_NUM) != null)
            request.getSession().removeAttribute(Constants.HOUSE_NUM);

        if (request.getSession().getAttribute(Constants.LUG_TYPE) != null)
            request.getSession().removeAttribute(Constants.LUG_TYPE);

        if (request.getSession().getAttribute(Constants.LUG_WEIGHT) != null)
            request.getSession().removeAttribute(Constants.LUG_WEIGHT);

        if (request.getSession().getAttribute(Constants.SHOW_REQ) != null)
            request.getSession().removeAttribute(Constants.SHOW_REQ);
        log.info("Fields were cleaned in /service");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
