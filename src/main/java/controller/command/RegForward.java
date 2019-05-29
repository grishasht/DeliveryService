package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegForward implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "forward:/WEB-INF/guest/registration.jsp";
    }
}
