package ua.epam.i18n;

import java.util.ListResourceBundle;

/**
 * Language bundle for ru_RU
 *
 * @author Ivanov Alexander
 */
public class LanguageBundle_ru extends ListResourceBundle {

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
        {"login.page.button.cancel", "Сбросить"},
        {"request.page.order", "Создать заявку"},
        {"request.page.date", "Дата проведения работ:"},
        {"request.page.type", "Тип работ:"},
        {"request.page.button.create", "Создать заказ"},
        {"request.page.button.cancel", "Сбросить"},
        {"page.button.back", "Назад"},
        {"listuser.page.list", "СПИСОК ЗАЯВОК"},
        {"listuser.page.table.number", "Номер заказа"},
        {"listuser.page.table.date", "Дата заказа"},
        {"listuser.page.table.workname", "Наименование работ"},
        {"listuser.page.table.workdate", "Дата выполнения заказа"},
        {"listuser.page.table.state", "Состояние"},
        {"listuser.page.table.empty", "Заказов нет!"},
        {"logout.page.leave", "Вы действительно хотите выйти?"},
        {"listworker.page.list", "СПИСОК РАБОТНИКОВ ЖЕКа"},
        {"listworker.page.table.name", "Имя"},
        {"listworker.page.table.lastname", "Фамилия"},
        {"listworker.page.table.prof", "Специальность"},
        {"listworker.page.table.busy", "Занятость"},
        {"listworker.page.busy", "Занят"},
        {"listworker.page.free", "Свободен"},
        {"listworker.page.table.empty", "Рабочих нет!"},
        {"workplan.page.plan", "РАБОЧИЙ ПЛАН."},
        {"workplan.page.table.response", "Ответственный за выполнение"},
        {"workplan.page.table.perform", "Выполняющий"},
        {"workplan.page.table.date", "Дата выполнения"},
        {"workplan.page.table.address", "Адрес"},
        {"workplan.page.table.empty", "Рабочий план пуст!"},
        {"listrequest.page.name", "НЕОБРАБОТАННЫЕ ЗАКАЗЫ."},
        {"listrequest.page.table.number", "Номер заказа"},
        {"listrequest.page.table.address", "Адрес"},
        {"listrequest.page.table.requdate", "Дата заказа"},
        {"listrequest.page.table.name", "Наименование работ"},
        {"listrequest.page.table.workdate", "Дата выполнения заказа"},
        {"listrequest.page.table.edit", "Редактировать"},
        {"listrequest.page.table.empty", "Заказов нет!"},
        {"edit.page.head", "РЕДАКТИРОВАНИЕ ЗАКАЗА"},
        {"edit.page.type", "Тип выполняемой работы"},
        {"edit.page.table.whodo", "Выполняющий:"},
        {"edit.page.table.resp", "Ответственный за выполнение:"},
        {"edit.page.button.handle", "Обработать"},
        {"edit.page.button.denied", "Отказать"},
        {"dispatcher.welcome", "Добро пожаловать, диспетчер"},
        {"dispatcher.list.worker", "Список работников ЖЕК"},
        {"dispatcher.list.workplan", "План работ"},
        {"dispatcher.exit", "Для выхода нажмите"},
        {"dispatcher.button", "Выход"},
        {"dispatcher.list.request", "Список заявок"}};

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
