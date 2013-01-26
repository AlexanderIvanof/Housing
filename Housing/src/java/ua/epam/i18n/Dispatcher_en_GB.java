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
public class Dispatcher_en_GB extends ListResourceBundle {

    static final Object[][] content = {
        {"dispatcher.welcome", "Welcome! You entered Dispatcher."},
        {"dispatcher.list.worker", "List of workers"},
        {"dispatcher.list.workplan", "Work plan"},
        {"dispatcher.exit", "For exit push "},
        {"dispatcher.button", "Exit"},
        {"dispatcher.list.request", "List of requests"}};

    @Override
    protected Object[][] getContents() {
        return content;
    }
}
