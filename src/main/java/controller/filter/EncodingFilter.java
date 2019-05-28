package controller.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(EncodingFilter.class);
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, NullPointerException{
        if (servletRequest.getCharacterEncoding() != null) {
            servletRequest.setCharacterEncoding(encoding);
        }
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
