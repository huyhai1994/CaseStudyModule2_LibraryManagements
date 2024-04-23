package library;

import java.util.Scanner;

class Main {
    static Scanner s;

    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System\n+" +
                "1.Login\n2. New User");
        s = new Scanner(System.in);
        int n = s.nextInt();
        switch (n) {
            case 1:
                login();
            case 2:
                newuser();
            default:
                System.out.println("Error!");
        }
    }

    private void login() {
        System.out.println("Enter phone number: ");
        String phonenumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
    }

    private static void newuser() {
        System.out.println("Enter name: ");
        String name = s.next();
        System.out.println("Enter Phone number: ");
        String phonenumber = s.next();
        System.out.println("Enter email: ");
        String email = s.next();
        System.out.println("1. Admin\n2.Normal User");
        int n2 = s.nextInt();
        if (n2 == 1) {

        } else {

        }
    }

}