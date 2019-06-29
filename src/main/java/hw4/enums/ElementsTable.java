package hw4.enums;

public enum ElementsTable {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String name;

    ElementsTable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}