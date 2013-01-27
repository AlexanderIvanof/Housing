/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.entity;

/**
 *
 * @author Alexandr Ivanov
 */
public enum Approve {

    WAIT_APPROVE("В обработке"), APPROVE("Принята"), COULD_NOT_BE("Отменена"), EMPTY("пусто");
    private String name;

    Approve(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
