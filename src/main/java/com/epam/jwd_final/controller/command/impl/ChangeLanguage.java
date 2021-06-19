package com.epam.jwd_final.controller.command.impl;

import com.epam.jwd_final.controller.command.Command;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLanguage implements Command {
    private static final Logger LOGGER = Logger.getLogger(ChangeLanguage.class);
    private static final String LOCALE = "locale";
    private static final String COOKIE_LOCALE = "locale";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String locale = req.getParameter(LOCALE);
        Cookie[] cookies = req.getCookies();

        Cookie localeCookie = findLocaleCookie(cookies);

        if ((locale.equals("en") || locale.equals("ru") || locale.equals("be")) && !locale.equals(localeCookie.getValue())) {
            localeCookie = updateLocaleCookie(localeCookie, locale);
            LOGGER.log(Level.DEBUG, "chang language: " + locale);
            resp.addCookie(localeCookie);
            resp.getWriter().write("update");
        }

    }

    private Cookie findLocaleCookie(Cookie[] cookies) {
        Cookie localeCookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(COOKIE_LOCALE)) {
                    localeCookie = cookies[i];
                    break;
                }
            }
        }
        return localeCookie;
    }

    private Cookie updateLocaleCookie(Cookie localeCookie, String locale) {
        if (localeCookie == null) {
            localeCookie = new Cookie(COOKIE_LOCALE, locale);
            localeCookie.setMaxAge(-1);
        } else {
            localeCookie.setValue(locale);
        }
        return localeCookie;
    }
}
