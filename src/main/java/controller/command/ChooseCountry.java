package controller.command;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChooseCountry implements Command {
    private Logger log = LogGenerator.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String countryName = request.getParameter(Constants.COUNTRY_NAME);
        request.getSession().setAttribute(Constants.COUNTRY_NAME, countryName);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        log.info("Country was chosen");

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
