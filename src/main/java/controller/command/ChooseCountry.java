package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChooseCountry implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String countryName = request.getParameter(Constants.COUNTRY_NAME);
        request.getSession().setAttribute(Constants.COUNTRY_NAME, countryName);
        String role = ((User) request.getSession().getAttribute(Constants.SESSION_USER))
                .getRole()
                .getValue();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(Constants.LOCAL_RB_BASE_NAME,
                Locale.forLanguageTag((String) request.getSession().getAttribute(Constants.CUR_LANG)));

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
