package com.aitu.entities;

import java.util.List;

public class Client extends Person {
    private String name;
    private int age;
    private String gender;
    private int balance;
    List<String> cars;

    public Client(String name, int age, String gender, int balance, List<String> clientCar) {
        super(name, age, gender);
        this.balance = balance;
        this.cars = clientCar;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<String> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Client{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", gender='" + super.getGender() + '\'' +
                ", balance=" + balance);

        if (!this.cars.isEmpty()) {
            sb.append("{Cars:");
            cars.forEach(car -> sb.append(car).append(" "));
            sb.append("}");
        }
        return sb.toString();
    }
}
