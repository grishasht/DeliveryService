package web.filter;

import model.entity.User;
import model.util.Constants;
import model.util.LogGenerator;
import model.util.Role;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoleFilter implements Filter {
    Map<Role, Set<String>> permissions = new HashMap<>();
    private Logger log = LogGenerator.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Set<String> adminRef = new HashSet<>();
        Set<String> userRef = new HashSet<>();
        Set<String> guestRef = new HashSet<>();

        adminRef.add("/");
        adminRef.add("/logout");

        userRef.add("/");
        userRef.add("/reg_fwd");
        userRef.add("/register");
        userRef.add("/logout");
        userRef.add("/requests");
        userRef.add("/service");
        userRef.add("/commit_req");
        userRef.add("/my_requests");
        userRef.add("/my_requests/pay");
        userRef.add("/my_requests/remove");
        userRef.add("/service/choose_country");
        userRef.add("/service/choose_city");
        userRef.add("/service/choose_street");
        userRef.add("/service/choose_house");
        userRef.add("/service/choose_lug_type");
        userRef.add("/service/create_req");
        userRef.add("/service/reset");

        guestRef.add("/");
        guestRef.add("/login");
        guestRef.add("/register");
        guestRef.add("/reg_fwd");
        guestRef.add("/service");
        guestRef.add("/commit_req");
        guestRef.add("/service/choose_country");
        guestRef.add("/service/choose_city");
        guestRef.add("/service/choose_street");
        guestRef.add("/service/choose_house");
        guestRef.add("/service/choose_lug_type");
        guestRef.add("/service/choose_weight");
        guestRef.add("/service/create_req");
        guestRef.add("/service/reset");

        permissions.put(Role.ADMIN, adminRef);
        permissions.put(Role.USER, userRef);
        permissions.put(Role.GUEST, guestRef);

        log.info("Role filter was initted");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI()
                .replace(request.getContextPath(), "")
                .replace(request.getServletPath(), "");

        if (request.getSession().getAttribute(Constants.SESSION_USER) == null) {
            request.getSession().setAttribute(Constants.SESSION_USER, new User().getGuest());
        }

        log.info("User was set in session");

        Role sessionRole = ((User) request.getSession().getAttribute(Constants.SESSION_USER)).getRole();

        if (!permissions.get(sessionRole).contains(requestURI)) {
            request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/errors/not_found.jsp")
                    .forward(request, response);
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
