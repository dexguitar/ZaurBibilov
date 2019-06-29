package lesson3.enums;

public enum LeftSideMenu {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service");

    final String name;

    LeftSideMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}