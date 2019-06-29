package hw4.enums;

public enum VegetablesDropdown {

    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String vegetable;

    VegetablesDropdown(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getVegetable() {
        return vegetable;
    }

}
