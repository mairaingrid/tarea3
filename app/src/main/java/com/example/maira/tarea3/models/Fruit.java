package com.example.maira.tarea3.models;

public class Fruit {
    private String name;
    private String description;
    private int bg;
    private int ic;
    private int quantity;

    public static final int LIMIT_QUANTITY = 10;
    public static final int RESET_VALUE_QUANTITY = 0;

    public Fruit(String fruts, String coco, String fresa, String pina, String uvas, int i) {
    }

    public Fruit(String name, String description, int fruts, int coco, int fresa, int bg, int ic, int quantity) {
        this.name = name;
        this.description = description;
        this.bg = bg;
        this.ic = ic;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getIc() {
        return ic;
    }

    public void setIc() {
        this.ic = ic;
    }

    public void addQuantity(int value) {

        if (quantity < LIMIT_QUANTITY)  quantity += value;

    }

    public void resetQuantity() {

        quantity = RESET_VALUE_QUANTITY;
    }

    public int getQuantity() {

        return quantity;
    }

}
