package hw6.enums;

public enum TopMenu {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    private String name;

    TopMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
