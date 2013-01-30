package ua.epam.entity;

/**
 * Enum approve request 
 * 
 * @author Alexandr Ivanov
 */
public enum Approve {

    WAIT_APPROVE("В обработке"), APPROVE("Принята"), COULD_NOT_BE("Отменена"), EMPTY("пусто");
    private String name;

    /**
     * Add ru name to enum.
     * 
     * @param name 
     */
    Approve(String name) {
        this.name = name;
    }
    /**
     * @return name 
     */
    public String getName() {
        return name;
    }
}
