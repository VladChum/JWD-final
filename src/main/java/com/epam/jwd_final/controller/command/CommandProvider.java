package com.epam.jwd_final.controller.command;

import com.epam.jwd_final.controller.command.impl.*;
import com.epam.jwd_final.controller.command.impl.admin.*;
import com.epam.jwd_final.controller.command.impl.page.*;
import com.epam.jwd_final.controller.command.impl.user.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public enum CommandProvider {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(CommandProvider.class);
    private final Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put("homePage", new HomePage());
        commands.put("tariffPage", new TariffPage());
        commands.put("aboutPage", new AboutCompanyPage());
        commands.put("loginPage", new LoginPage());
        commands.put("userPage", new UserPage());
        commands.put("adminPage", new AdminPage());
        commands.put("signIn", new SignIn());
        commands.put("signOut", new SignOut());
        commands.put("createTariff", new CreateTariff());
        commands.put("createUser", new CreateUser());
        commands.put("deleteTariff", new DeleteTariff());
        commands.put("createAdmin", new CreateAdmin());
        commands.put("activateTariff", new ActivateTariff());
        commands.put("createDiscount", new CreateDiscount());
        commands.put("stopDiscount", new StopDiscount());
        commands.put("addTariffsToDiscount", new AddTariffsToDiscount());
        commands.put("deleteUser", new DeleteUser());
        commands.put("deleteAdmin", new DeleteAdmin());
        commands.put("chengUserStatus", new ChangeUserStatus());
        commands.put("userPayment", new Payment());
        commands.put("personalAccount", new PersonalAccount());
        commands.put("updateTariff", new UpdateTariff());
        commands.put("updateUserEmail", new UpdateUserEmail());
        commands.put("updateUserPhone", new UpdateUserPhone());
        commands.put("updateDiscount", new UpdateDiscount());
        commands.put("updatePassword", new UpdatePassword());
        commands.put("updateUserTariff", new UpdateUserTariff());
        commands.put("registerUser", new RegisterUser());
        commands.put("unblockUser", new UnblockUser());
        commands.put("changLanguage", new ChangeLanguage());
        commands.put("findUsersByCriteria", new FindUserByCriteria());
    }

    public Command getCommand(String commandName) {
        LOGGER.log(Level.DEBUG, "command name: " + commandName.toUpperCase());
        return commands.get(commandName);
    }
}
