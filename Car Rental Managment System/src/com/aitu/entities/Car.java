package com.aitu.entities;

public class Car {
    private String brand;
    private String model;
    private String color;
    private String type;
    private int price;

    private String make;
    private int year;
    private boolean hasSunroof;
    private boolean hasGPS;
    private boolean hasLeatherSeats;

    public Car(String brand, String model, String color, String type, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.type = type;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                "}";
    }

//    private Cars(CarBuilder builder) {
//        this.make = builder.make;
//        this.model = builder.model;
//        this.year = builder.year;
//        this.hasSunroof = builder.hasSunroof;
//        this.hasGPS = builder.hasGPS;
//        this.hasLeatherSeats = builder.hasLeatherSeats;
//    }

}






