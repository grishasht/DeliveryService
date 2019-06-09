package controller.command;

import model.entity.User;
import model.util.Constants;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User guest = User.getGuest();
        request.getSession().setAttribute(Constants.SESSION_USER, guest);
        String curLang = (String) request.getSession().getAttribute(Constants.CUR_LANG);
        return "redirect:/page/?curLang=" + curLang;
    }
}
