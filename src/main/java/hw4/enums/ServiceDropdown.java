package hw4.enums;

public enum ServiceDropdown {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    final String name;

    ServiceDropdown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
