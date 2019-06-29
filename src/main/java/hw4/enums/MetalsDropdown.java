package hw4.enums;

public enum MetalsDropdown {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String metal;

    MetalsDropdown(String metal) {
        this.metal = metal;
    }

    public String getMetal() {
        return metal;
    }

}