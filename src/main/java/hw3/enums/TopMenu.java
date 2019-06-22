package hw3.enums;

public enum TopMenu {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    TopMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
