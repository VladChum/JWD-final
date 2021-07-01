package com.epam.jwd_final.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class AdminFilter implements Filter {
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ADMIN_PAGE = "/Controller?command=adminPage";
    private static final String USER_PAGE = "/Controller?command=userPage";

    private final String[] userCommand = {"homePage", "tariffPage", "aboutPage", "userPage", "loginPage", "signIn", "registerUser", "signOut", "tariffPageButton",
            "changLanguage", "chengUserStatus", "userPayment", "personalAccount", "updateTariff", "updateUserEmail", "updateUserPhone", "updatePassword", "updateUserTariff", "unblockUser"};
    private final String[] adminCommand = {"homePage", "tariffPage", "aboutPage", "adminPage", "loginPage", "signIn", "registerUser", "signOut", "tariffPageButton", "changLanguage",
            "createTariff", "createUser", "deleteTariff", "createAdmin", "activateTariff", "createDiscount", "stopDiscount", "addTariffsToDiscount", "deleteUser", "deleteAdmin",
            "chengUserStatus", "personalAccount", "updateTariff", "updateDiscount", "updatePassword", "registerUser", "unblockUser", "findUsersByCriteria"};

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
        if (httpSession != null) {
            Object user = httpSession.getAttribute(USER);
            Object admin = httpSession.getAttribute(ADMIN);
            if (admin != null) {
                adminFilter(command, response, servletRequest, servletResponse, filterChain, admin);
            } else {
                userFilter(command, response, servletRequest, servletResponse, filterChain, user);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void adminFilter(String command, HttpServletResponse response, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, Object admin) throws IOException, ServletException {
        if (admin != null && Arrays.stream(adminCommand).noneMatch(command::equalsIgnoreCase)) {
            response.sendRedirect(ADMIN_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void userFilter(String command, HttpServletResponse response, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, Object user) throws IOException, ServletException {
        if (user != null && Arrays.stream(userCommand).noneMatch(command::equalsIgnoreCase)) {
            response.sendRedirect(USER_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
