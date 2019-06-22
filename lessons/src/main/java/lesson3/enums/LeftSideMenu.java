package lesson3.enums;

public enum LeftSideMenu {

    HOME("Home"),
    CONTACT_FORM("Contact form");

    final String name;

    LeftSideMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
