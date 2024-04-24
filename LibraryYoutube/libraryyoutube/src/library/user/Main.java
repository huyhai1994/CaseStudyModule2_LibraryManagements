package library;

import java.util.Scanner;
class Main {
    static Scanner scanner;
    static DataBase database;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Library Management System\n");
        database = new DataBase();
        int options;
        boolean isUserNotWantToExit;
        do {
            System.out.println(" 0. Exit\n 1.Login\n 2. New User");
            scanner = new Scanner(System.in);
            options = scanner.nextInt();
            switch (options) {
                case 1:
                    login();
                    break;
                case 2:
                    newUser();
                    break;
                case 0:
                    System.out.println("Exit Library Management System !!!");
                    break;
                default:
                    System.out.println("Error!");
            }
            isUserNotWantToExit = options != 0;
        } while (isUserNotWantToExit);
    }

    private static void login() {

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        int locationOfMatchedUser = database.login(phoneNumber, email);
        boolean isUserFound = locationOfMatchedUser != -1;
        if (isUserFound) {
            User user = database.getUser(locationOfMatchedUser);
            user.menu(database, user);
        } else {
            System.out.println("User not found!!!");
        }
    }

    private static void newUser() {
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter Phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2.Normal User");
        int adminOrNormalUserOption = scanner.nextInt();
        User user;
        boolean isUserIsAdmin = adminOrNormalUserOption == 1;
        if (isUserIsAdmin) {
            user = new Admin(name, email, phoneNumber);
        } else {
            user = new NormalUser(name, email, phoneNumber);
        }
        database.addUser(user);
        System.out.println("User created successfully!");
        user.menu(database, user);
    }

}