package controller.filter;

import model.util.Constants;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getParameter(Constants.CUR_LANG) != null){
            request.getSession().setAttribute(Constants.CUR_LANG, request.getParameter(Constants.CUR_LANG));
        } else {
            request.getSession().setAttribute(Constants.CUR_LANG, Locale.getDefault().getLanguage());
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
