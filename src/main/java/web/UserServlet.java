package web;

import model.entity.Luggage;
import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean jstl = Boolean.getBoolean(req.getParameter("jstl"));

        List<Luggage> luggages = new LinkedList<>();
        Luggage luggage= new Luggage();
        luggage.setType("asda");
        luggage.setWeight((float) 34.0);
        luggage.setId(1);
        luggage.setPrice(23f);

        luggages.add(luggage);
        req.setAttribute("luggage", luggages);
        if (jstl){
            req.getRequestDispatcher("luggage-no-jstl.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("luggage.jsp").forward(req, resp);
        }
    }
}
