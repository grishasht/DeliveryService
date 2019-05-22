package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class HelloServlet extends HttpServlet {
    //private static final LogGenerator LOGGER = LogGenerator.getLogger();
    private String encoding;
    private String language;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.encoding = config.getInitParameter("encoding");
        this.language = getServletContext().toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
    //    LOGGER.info("resp type: " + resp.getContentType());
        resp.setContentType("charset= " + encoding);
        resp.setCharacterEncoding(this.encoding);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Hello from server " + name);
        printWriter.println("Кодировка " +  resp.getCharacterEncoding());
        printWriter.println("Default language" + this.language);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//
//        String name = request.getParameter("username");
//        String age = request.getParameter("userage");
//        String gender = request.getParameter("gender");
//        String country = request.getParameter("country");
//        String[] courses = request.getParameterValues("courses");
//
//        try {
//            writer.println("<p>Name: " + name + "</p>");
//            writer.println("<p>Age: " + age + "</p>");
//            writer.println("<p>Gender: " + gender + "</p>");
//            writer.println("<p>Country: " + country + "</p>");
//            writer.println("<h4>Courses</h4>");
//            for(String course: courses)
//                writer.println("<li>" + course + "</li>");
//        } finally {
//            writer.close();
//        }
//    }
}
