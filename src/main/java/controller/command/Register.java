package controller.command;

import model.entity.User;
import model.service.UserService;
import model.util.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register implements Command {
    private UserService userService = new UserService();

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
        user.setLogin(name);

        userService.registerUser(user);

        System.out.println(user.toString());

        return "redirect:/";
    }
}
