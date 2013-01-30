package ua.epam.i18n;

import java.util.ListResourceBundle;

/**
 * Language bundle for en_GB
 * 
 * @author Ivanov Alexander
 */
public class LanguageBundle_en_GB extends ListResourceBundle {

    static final Object[][] contents = {
        {"welcome.page.welcome", "Welcome to our start page!"},
        {"welcome.page.loggin", "You are log in as"},
        {"welcome.page.create", "Create request"},
        {"welcome.page.show", "Show my requests"},
        {"welcome.page.exit", "For exit push "},
        {"welcome.page.button", "Exit"},
        {"welcome.page.flag", "images/flag_GB.jpg"},
        {"locale.page.choose", "Choose the language "},
        {"login.page.welcome", "Welcome to the HOUSING."},
        {"login.page.continue", "Please log in to continue."},
        {"login.page.username", "Username:"},
        {"login.page.password", "Password:"},
        {"login.page.button.ok", "Ok"},
        {"login.page.button.cancel", "Cancel"}};

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
