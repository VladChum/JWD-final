package com.epam.jwd.controller.command.impl;

import com.epam.jwd.controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLanguage implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeLanguage.class);

    private static final String LOCALE = "locale";
    private static final String COOKIE_LOCALE = "locale";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String locale = req.getParameter(LOCALE);
        Cookie[] cookies = req.getCookies();

        Cookie localeCookie = findLocaleCookie(cookies);

        if ((locale.equals("en") || locale.equals("ru") || locale.equals("be")) && !locale.equals(localeCookie.getValue())) {
            localeCookie = updateLocaleCookie(localeCookie, locale);
            LOGGER.debug("chang language: " + locale);
            resp.addCookie(localeCookie);
            resp.getWriter().write("update");
        }

    }

    private Cookie findLocaleCookie(Cookie[] cookies) {
        Cookie localeCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_LOCALE)) {
                    localeCookie = cookie;
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
