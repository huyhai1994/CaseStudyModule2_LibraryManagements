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

    public static void main(String[] args) throws Exception {
        int userOption = setOptions();
        database = new DataBase();
        
        do {
            printWelcome();
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
        } while (userOption != 0);
    }

    public static void printWelcome() {
        System.out.println("Welcome to Library Management System");
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
            } else {
                return;
            }
        } catch (Exception e) {
            System.out.println("User not exit!!!");
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
            user = new Admin(name, email, phoneNumber);
            database.addUser(user);
        } else if (isUserIsNormalUser) {
            user = new NormalUser(name, email, phoneNumber);
            database.addUser(user);
        }
        System.out.println("Account created succesfully!!!");

    }

    public static int setOptions() {
        System.out.println("1. Login\n 2. New user\n");
        scanner = new Scanner(System.in);
        int options = scanner.nextInt();

        return options;
    }
}