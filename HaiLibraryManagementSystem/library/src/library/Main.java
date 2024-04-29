package library;

import java.io.IOException;
import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class Main {

    static Scanner scanner;
    static DataBase database;
    static final int ONE = 1;
    static final int TWO = 2;
    static final String ADMIN = "admin";
    static final String NORMAL_USER = "normalUser";

    public static void main(String[] args) throws Exception {
        printWelcome();
        int userOption = setOptions();
        database = new DataBase();
        database.showUsers();

        do {

            switch (userOption) {
                case (ONE):
                    login();
                    break;
                case (TWO):
                    newUser();
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
            userOption = setOptions();
        } while (userOption != 0);
    }

    public static void printWelcome() {

        System.out.println("\n------Welcome to Library Management System---------\n");
    }

    private static void login() {
        try {
            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            int indexOfUser = database.checkLogin(phoneNumber, email);
            if (indexOfUser != -1) {
                User user = database.getUser(indexOfUser);
                System.out.println("Welcome user + " + user.getName());
                user.menu();

            } else {
                System.out.println("User not exit!!!");

                return;
            }
        } catch (Exception e) {

        }
    }

    private static void newUser() throws IOException {
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2. Nomal User");
        int userChoose = scanner.nextInt();
        boolean isUserIsAdmin = userChoose == 1;
        boolean isUserIsNormalUser = userChoose == 2;
        User user;
        if (isUserIsAdmin) {
            user = new Admin(name, email, phoneNumber, ADMIN);
            database.addUser(user);
        } else if (isUserIsNormalUser) {
            user = new NormalUser(name, email, phoneNumber, NORMAL_USER);
            database.addUser(user);
        }

        System.out.println("Account created succesfully!!!");
        return;
    }

    public static int setOptions() {
        System.out.println("1. Login\n 2. New user\n");
        scanner = new Scanner(System.in);
        int options = scanner.nextInt();

        return options;
    }
}