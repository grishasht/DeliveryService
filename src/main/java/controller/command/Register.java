package controller.command;

import model.entity.User;
import model.util.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        user.setLogin(email);



        System.out.println(user.toString());

        return "";
    }
}
