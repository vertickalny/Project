package com.aitu.application;

import repositories.Impl.CarRepositoryImpl;
import repositories.Impl.ClientRepositoryImpl;
import repositories.Impl.RentalImpl;

import java.sql.SQLException;
import java.util.*;

public class MyApplication implements Application {
    private ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();
    private CarRepositoryImpl carRepository = new CarRepositoryImpl();
    private RentalImpl rental= new RentalImpl();
    private Scanner in = new Scanner(System.in);

    @Override
    public void start() throws SQLException {
        System.out.println("Welcome to car rental management system");
        System.out.println("[1] --> control clients");
        System.out.println("[2] --> control cars");
        System.out.println("[3] --> control rental");
        System.out.println("[4] --> close app");

        while (true){
            System.err.println("enter key number");
            int n = in.nextInt();
            switch (n){
                case 1 -> controlClients();
                case 2 -> controlCars();
                case 3 -> controlRental();
                case 4 -> exit();
                default -> System.out.println("invalid number");
            }
        }
    }

    private void controlClients() throws SQLException {

        System.out.println("welcome to clients control system");
        System.out.println("[1] -> add client");
        System.out.println("[2] -> delete user");
        System.out.println("[3] -> show all users");
        System.out.println("[4] -> go to main page ");
        System.out.println("[5] -> close app");

        while (true){

            System.err.println("enter key number");
            int n = in.nextInt();
            switch (n){
                case 1 -> clientRepository.add();
                case 2 -> clientRepository.delete();
                case 3 -> clientRepository.getAll().forEach(System.out::println);
                case 4 -> start();
                case 5 -> exit();

            }
        }
    }

    private void controlCars() throws SQLException{
        System.out.println("welcome to car control system");
        System.out.println("[1] -> add cars");
        System.out.println("[2] -> show all cars");
        System.out.println("[3] -> go to main page ");
        System.out.println("[4] -> close app");

        while (true){
            System.err.println("enter key number");

            int n = in.nextInt();

            switch (n){
                case 1 -> carRepository.add();
                case 2 -> carRepository.getAll().forEach(System.out::println);
                case 3 -> start();
                case 4 -> exit();
                default -> System.out.println("in valid number");

            }
        }
    }


    private void controlRental() throws SQLException{

        System.out.println("welcome to rental control system");
        System.out.println("[1] -> rental car ");
        System.out.println("[3] -> go to main page ");
        System.out.println("[4] -> close app ");

        while (true){
            System.err.println("enter key number");
            int n = in.nextInt();
            switch (n){
                case 1 -> rental.rentalCar();
                case 3 -> start();
                case 4 -> exit();
                default -> System.out.println("in valid number");
            }
        }
    }


}