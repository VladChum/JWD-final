package com.epam.jwd_final.controller.command;

import com.epam.jwd_final.controller.command.impl.AboutCompanyPage;
import com.epam.jwd_final.controller.command.impl.HomePage;
import com.epam.jwd_final.controller.command.impl.TariffPage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public enum ProviderCommand {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ProviderCommand.class);
    private Map<String, Command> commands = new HashMap<>();

    ProviderCommand() {
        commands.put("HOME_PAGE", new HomePage());
        commands.put("TARIFF_PAGE", new TariffPage());
        commands.put("ABOUT_PAGE", new AboutCompanyPage());
    }

    public Command getCommand(String commandName) {
        LOGGER.log(Level.DEBUG, "command name: " + commandName.toUpperCase());
        return  commands.get(commandName);
    }
}
