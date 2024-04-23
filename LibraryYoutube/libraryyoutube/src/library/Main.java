package library;

import java.util.Scanner;

class Main {
    static Scanner s;
    static DataBase database;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Library Management System\n");
        database = new DataBase();
        int options;
        boolean isUserDontWantToExit;
        do {
            System.out.println(" 0. Exit\n 1.Login\n 2. New User");
            s = new Scanner(System.in);
            options = s.nextInt();
            switch (options) {
                case 1:
                    login();
                    break;
                case 2:
                    newuser();
                    break;
                case 0:
                    System.out.println("Exit Library Management System !!!");
                    break;
                default:
                    System.out.println("Error!");
            }
            isUserDontWantToExit = options != 0;
        } while (isUserDontWantToExit);
    }

    /**
     * This method is responsible for handling the login process for users.
     * It prompts the user to enter their phone number and email, then attempts to
     * log them in using the provided data.
     * If the login is successful, it retrieves the user object from the database
     * and calls the user's menu method.
     * If the login fails, it prints a message indicating that the user was not
     * found.
     *
     * @param phoneNumber The phone number entered by the user.
     * @param email       The email entered by the user.
     */
    private static void login() {

        System.out.println("Enter phone number: ");
        String phoneNumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
        int n = database.login(phoneNumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu();
        } else {
            System.out.println("User not found!!!");
        }
    }

    private static void newuser() {
        System.out.println("Enter name: ");
        String name = s.next();
        System.out.println("Enter Phone number: ");
        String phoneNumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
        System.out.println("1. Admin\n2.Normal User");
        int n2 = s.nextInt();
        User user;
        if (n2 == 1) {
            user = new Admin(name, email, phoneNumber);
        } else {
            user = new NormalUser(name, email, phoneNumber);
        }
        database.AddUser(user);
        System.out.println("User created successfully!");
        user.menu();
    }

}