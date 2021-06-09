package com.epam.jwd_final.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TariffPageFilter implements Filter {
    private final String USER = "user";
    private final String ADMIN = "admin";
    private final String LOGIN_PAGE = "/Controller?command=loginPage";
    private final String USER_PAGE = "/Controller?command=userPage";
    private final String ADMIN_PAGE = "/Controller?command=adminPage";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession = request.getSession();

        String command = request.getParameter("command");
        if (httpSession != null && command.equals("tariffPageButton")) {
            if (httpSession.getAttribute(USER) != null) {
                response.sendRedirect(USER_PAGE);
            } else if (httpSession.getAttribute(ADMIN) != null) {
                response.sendRedirect(ADMIN_PAGE);
            } else {
                response.sendRedirect(LOGIN_PAGE);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
