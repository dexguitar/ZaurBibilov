package hw4.enums;

public enum NumbersDropdown {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    final int number;

    NumbersDropdown(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
