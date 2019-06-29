package hw4.enums;

public enum ColorsDropdown {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String color;

    ColorsDropdown(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}