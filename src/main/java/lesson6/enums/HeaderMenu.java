package lesson6.enums;

public enum HeaderMenu {

    SERVICE("Service");

    private String name;

    HeaderMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}