package com.epam.jwd_final.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class AuthorizationFilter implements Filter {
    private final String ACCOUNT = "account";
    private final String[] whiteList = {"homePage", "tariffPage", "aboutPage", "loginPage", "signIn", "registerUser", "signOut", "tariffPageButton"};
    private final String LOGIN_PAGE = "/Controller?command=loginPage";

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
        HttpSession httpSession = request.getSession(false);

        String command = request.getParameter("command");
        if (httpSession != null) {
            Object account = httpSession.getAttribute(ACCOUNT);
            if (account == null && Arrays.stream(whiteList).noneMatch(command::equalsIgnoreCase)) {
                response.sendRedirect(LOGIN_PAGE);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
