package it.edu.iiscopernico.paymentcalculator;

public class Item {
    private final String name;
    private final int imageResId;
    private final int amount;
    private final String unit;
    private int count = 0;

    public Item(String name, int amount, String unit, int imageResId) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.imageResId = imageResId;
    }

    public Item(String name, int imageResId) {
        this.name = name;
        this.amount = 0;
        this.unit = "";
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        if (count > 0) count--;
    }
}