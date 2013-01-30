package ua.epam.i18n;

import java.util.ListResourceBundle;

/**
 * Language bundle for ru_RU
 * 
 * @author Ivanov Alexander
 */
public class LanguageBundle_ru_RU extends ListResourceBundle{

    static Object[][] contents = {
        {"welcome.page.welcome", "Добро пожаловать на стартовую страницу!"},
        {"welcome.page.loggin", "Вы авторизовались как "},
        {"welcome.page.create", "Создать заявку."},
        {"welcome.page.show", "Просмотреть заявки."},
        {"welcome.page.exit", "Для выхода нажмите "},
        {"welcome.page.button", "Выход"},
        {"welcome.page.flag", "images/flag_ru.gif"},
        {"locale.page.choose", "Выберите язык"},
        {"login.page.welcome", "Добро пожаловать на страницу ЖЕК"},
        {"login.page.continue", "Для продолжения работы необходимо авторизоваться"},
        {"login.page.username", "Имя пользователя:"},
        {"login.page.password", "Пароль:"},
        {"login.page.button.ok", "Принять"},
        {"login.page.button.cancel", "Сбросить"}};
    
    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
