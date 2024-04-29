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
        database = new DataBase();
        printWelcome();
        int userOption = setOptions();
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
        System.out.println("\n------Chao Mung den Thu Vien So ---------\n");
    }

    private static void login() {
        try {
            System.out.println("Moi nhap so dien thoai: ");
            String phoneNumber = scanner.next();
            System.out.println("Moi nhap email: ");
            String email = scanner.next();
            int indexOfUser = database.checkLogin(phoneNumber, email);
            boolean isUserExist = indexOfUser != -1;
            if (isUserExist) {
                User user = database.getUser(indexOfUser);
                System.out.println("Chao mung anh/chi " + user.getName());
                user.menu(database, user);
            } else {
                System.out.println("Tai khoan khong ton tai!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void newUser() throws IOException {
        User user;
        System.out.println("Nhap Ten: ");
        String name = scanner.next();
        System.out.println("Nhap So Dien Thoai: ");
        String phoneNumber = scanner.next();
        System.out.println("Nhap email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2. Tai Khoan Binh Thuong");
        int userChoose = scanner.nextInt();
        boolean isUserIsAdmin = userChoose == 1;
        boolean isUserIsNormalUser = userChoose == 2;

        if (isUserIsAdmin) {
            user = new Admin(name, email, phoneNumber, ADMIN);
            database.addUser(user);
            user.menu(database, user);
        } else if (isUserIsNormalUser) {
            user = new NormalUser(name, email, phoneNumber, NORMAL_USER);
            database.addUser(user);
            user.menu(database, user);
        }
        System.out.println("Tai Khoan Tao Thanh Cong!!!");
    }

    public static int setOptions() {
        System.out.println("1. Dang Nhap \n 2. Tao Tai Khoan Moi\n");
        scanner = new Scanner(System.in);
        int options = scanner.nextInt();
        return options;
    }
}