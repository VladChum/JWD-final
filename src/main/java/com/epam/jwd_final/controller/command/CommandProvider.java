package com.epam.jwd_final.controller.command;

import com.epam.jwd_final.controller.command.impl.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public enum CommandProvider {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(CommandProvider.class);
    private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put("homePage", new HomePage());
        commands.put("tariffPage", new TariffPage());
        commands.put("aboutPage", new AboutCompanyPage());
        commands.put("loginPage", new LoginPage());
        commands.put("signIn", new SignIn());
        commands.put("userPage", new UserPage());
        commands.put("adminPage", new AdminPage());
        commands.put("updateTariff", new UpdateTariff());
    }

    public Command getCommand(String commandName) {
        LOGGER.log(Level.DEBUG, "command name: " + commandName.toUpperCase());
        return  commands.get(commandName);
    }
}
