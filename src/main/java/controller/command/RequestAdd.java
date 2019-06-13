package controller.command;

import model.entity.User;
import model.service.RequestService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestAdd implements Command {
    private RequestService requestService = new RequestService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        String role = user.getRole().getValue();

        String country = (String) request.getSession().getAttribute(Constants.COUNTRY_NAME);
        String city = (String) request.getSession().getAttribute(Constants.CITY_NAME);
        String street = (String) request.getSession().getAttribute(Constants.STREET_NAME);
        String house = (String) request.getSession().getAttribute(Constants.HOUSE_NUM);
        String luggage = (String) request.getSession().getAttribute(Constants.LUG_TYPE);
        String weight = request.getParameter(Constants.LUG_WEIGHT);
        request.getSession().setAttribute(Constants.LUG_WEIGHT, weight);

        if (!requestService.isNumeric(house, weight)) {
            return "forward:/WEB-INF/errors/smth_wrong.jsp";
        } else if (requestService.dataExistence(country, city, street, luggage, weight)) {
            request.getSession().setAttribute(Constants.SHOW_REQ, true);
        } else {
            request.getSession().setAttribute(Constants.SHOW_REQ, false);
        }

        return "forward:/WEB-INF/" + role + "/service.jsp";
    }
}
