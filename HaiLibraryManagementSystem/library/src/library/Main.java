package library;

import java.util.Scanner;

public class Main {
    
    
   static Scanner scanner; 
    public static void main(String[] args) throws Exception {
        printWelcome();
        int userOption = setOptions();

        switch (userOption) {
            case (1): 
                login();
                break;
            case (2)
                newUser();
                break;
            default:
                System.out.println("Error!");     
            break;
        } 
            
    }
    public static void printWelcome(){
        System.out.println("Welcome to Library Management System");
    }

    private static void login(){
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();

    }
    private static void newUser(){
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2. Nomal User");
    }
    public static int setOptions(){
        System.out.println("1. Login\n 2. New user\n");
        scanner = new Scanner(System.in);
        int options = scanner.nextInt();
        
        return options;
    }
}