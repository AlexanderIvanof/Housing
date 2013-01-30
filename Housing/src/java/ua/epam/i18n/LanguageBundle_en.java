package ua.epam.i18n;

import java.util.ListResourceBundle;

/**
 * Language bundle for en_GB
 * 
 * @author Ivanov Alexander
 */
public class LanguageBundle_en extends ListResourceBundle {

    static final Object[][] contents = {
        {"welcome.page.welcome", "Welcome to our start page!"},
        {"welcome.page.loggin", "You are log in as"},
        {"welcome.page.create", "Create request"},
        {"welcome.page.show", "Show my requests"},
        {"welcome.page.exit", "For exit push"},
        {"welcome.page.button", "Exit"},
        {"welcome.page.flag", "images/flag_GB.jpg"},
        {"locale.page.choose", "Choose the language"},
        {"login.page.welcome", "Welcome to the HOUSING."},
        {"login.page.continue", "Please log in to continue."},
        {"login.page.username", "Username:"},
        {"login.page.password", "Password:"},
        {"login.page.button.ok", "Ok"},
        {"login.page.button.cancel", "Cancel"},
        {"request.page.order", "To order work"},
        {"request.page.date", "Work date:"},
        {"request.page.type", "Work type:"},
        {"request.page.button.create", "Create"},
        {"request.page.button.cancel", "Cancel"},
        {"page.button.back", "Back"},
        {"listuser.page.list", "REQUEST LIST"},
        {"listuser.page.table.number", "Number"},
        {"listuser.page.table.date", "Request date"},
        {"listuser.page.table.workname", "Work type"},
        {"listuser.page.table.workdate", "Work date"},
        {"listuser.page.table.state", "State"},
        {"listuser.page.table.empty", "There are no requests!"},
        {"logout.page.leave", "You really want to logout?"},
        {"listworker.page.list", "WORKER LIST"},
        {"listworker.page.table.name", "Name"},
        {"listworker.page.table.lastname", "Surname"},
        {"listworker.page.table.prof", "Profession"},
        {"listworker.page.table.busy", "is busy"},
        {"listworker.page.busy", "busy"},
        {"listworker.page.free", "free"},
        {"listworker.page.table.empty", "There are no workers!"},
        {"workplan.page.plan", "WORK PLAN."},
        {"workplan.page.table.response", "Responsible for executing"},
        {"workplan.page.table.perform", "Perform"},
        {"workplan.page.table.date", "Execution date"},
        {"workplan.page.table.address", "Addres"},
        {"workplan.page.table.empty", "Work plan is empty!"},
        {"listrequest.page.name", "UNPROCESSED REQUESTS."},
        {"listrequest.page.table.number", "№"},
        {"listrequest.page.table.address", "Address"},
        {"listrequest.page.table.requdate", "Request date"},
        {"listrequest.page.table.name", "Type work"},
        {"listrequest.page.table.workdate", "Work date"},
        {"listrequest.page.table.edit", "Edit"},
        {"listrequest.page.table.empty", "There are no requests!"},
        {"edit.page.head", "EDIT REQUESTS"},
        {"edit.page.type", "Work type is"},
        {"edit.page.table.whodo", "Executor:"},
        {"edit.page.table.resp", "Responsible for executing:"},
        {"edit.page.button.handle", "Handle"},
        {"edit.page.button.denied", "Denied"},
        {"dispatcher.welcome", "Welcome! You entered Dispatcher."},
        {"dispatcher.list.worker", "List of workers"},
        {"dispatcher.list.workplan", "Work plan"},
        {"dispatcher.exit", "For exit push "},
        {"dispatcher.button", "Exit"},
        {"dispatcher.list.request", "List of requests"}};

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
