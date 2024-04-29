package library.user;

import java.util.Scanner;

import library.database.DataBase;
import library.iooperation.*;

public class Admin extends User {

    private IOOperation[] operations;

    public Admin(String name) {
        super(name);
        this.operations = new IOOperation[] {
                new ViewBook(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders()
        };
    }

    public Admin(String name, String email, String phoneNumber, String role) {
        super(name, email, phoneNumber, role);
        this.operations = new IOOperation[] {
                new ViewBook(),
                new AddBook(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders()
        };
    }

    @Override
    public String toString() {
        return this.getName() + "|" +
                this.getEmail() + "|" +
                this.getPhoneNumber() + "|" +
                this.getRole();
    }

    @Override
    public void menu(DataBase dataBase, User user) {
        System.out.println("Here is Admin menu");
        System.out.println("-------------------");
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search Books");
        System.out.println("5. Delete all data");
        System.out.println("6. View orders");
        System.out.println("7. Exit");

        Scanner scanner = new Scanner(System.in);
        int adminchoise = scanner.nextInt();
        this.operations[adminchoise - 1].operation(dataBase,user);
        scanner.close();

    }

}
