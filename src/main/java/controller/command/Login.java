package controller.command;

import model.entity.User;
import model.service.UserService;
import model.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Login implements Command {
    UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.identifyUser(login, password);

        if (!User.getGuest().equals(user)) {
            userService.authorize(user, request);
            return "forward:/WEB-INF/user/index.jsp";
        } else {
            return "redirect:/page/?curLang="
                    + request.getSession().getAttribute(Constants.CUR_LANG);
        }
    }
}
