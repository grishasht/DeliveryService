package web.filter;

import model.entity.User;
import model.util.Constants;
import model.util.Role;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Set<String> adminRef = new HashSet<>();
        Set<String> userRef = new HashSet<>();
        Set<String> guestRef = new HashSet<>();

        adminRef.add("/");
        adminRef.add("/logout");

        userRef.add("/");
        userRef.add("/logout");
        userRef.add("/add_lug");
        userRef.add("/remove_lug");
        userRef.add("/my_requests");
        userRef.add("/add_request");
        userRef.add("/remove_request");

        guestRef.add("/");
        guestRef.add("/login");
        guestRef.add("/register");
        guestRef.add("/reg_forward");

        permissions.put(Role.ADMIN, adminRef);
        permissions.put(Role.USER, userRef);
        permissions.put(Role.GUEST, guestRef);
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

        Role sessionRole = ((User) request.getSession().getAttribute(Constants.SESSION_USER)).getRole();

        if (!permissions.get(sessionRole).contains(requestURI)) {
            request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/errors/forb.jsp")
                    .forward(request, response);
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
