package com.epam.jwd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminFilter implements Filter {
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ADMIN_PAGE = "/Controller?command=adminPage";
    private static final String USER_PAGE = "/Controller?command=userPage";

    private final List<String> generalCommand = new ArrayList<>(List.of("homePage", "tariffPage", "aboutPage", "loginPage", "signIn", "registerUser",
            "signOut", "tariffPageButton", "changLanguage", "updatePassword", "unblockUser", "personalAccount", "chengUserStatus"));
    private final List<String> userCommand = new ArrayList<>(List.of("userPage", "userPayment", "updateTariff", "updateUserEmail", "updateUserPhone", "updateUserTariff"));
    private final List<String> adminCommand = new ArrayList<>(List.of("adminPage", "createTariff", "createUser", "deleteTariff", "createAdmin",
            "activateTariff", "createDiscount", "stopDiscount", "addTariffsToDiscount", "deleteUser", "deleteAdmin", "updateTariff", "updateDiscount", "registerUser", "findUsersByCriteria", "findUserInfo"));

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
        if (admin != null && !adminCommand.contains(command) && !generalCommand.contains(command)) {
            response.sendRedirect(ADMIN_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void userFilter(String command, HttpServletResponse response, ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, Object user) throws IOException, ServletException {
        System.out.println(userCommand.contains(command));
        System.out.println(generalCommand.contains(command));
        if (user != null && !userCommand.contains(command) && !generalCommand.contains(command)) {
            response.sendRedirect(USER_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
