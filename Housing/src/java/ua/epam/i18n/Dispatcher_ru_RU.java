/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.i18n;

import java.util.ListResourceBundle;

/**
 *
 * @author Ivanov Alexander
 */
public class Dispatcher_ru_RU extends ListResourceBundle {

    static final Object[][] content = {
        {"dispatcher.welcome", "Добро пожаловать, диспетчер"},
        {"dispatcher.list.worker", "Список работников ЖЕК"},
        {"dispatcher.list.workplan", "План работ"},
        {"dispatcher.exit", "Для выхода нажмите"},
        {"dispatcher.button", "Выход"},
        {"dispatcher.list.request", "Список заявок"}};

    @Override
    protected Object[][] getContents() {
        return content;
    }
}
