package library.user;

import java.util.Scanner;

import library.database.DataBase;
import library.iooperation.BorrowBook;
import library.iooperation.CalculateFine;
import library.iooperation.Exit;
import library.iooperation.IOOperation;
import library.iooperation.PlaceOrder;
import library.iooperation.ReturnBook;
import library.iooperation.Search;
import library.iooperation.ViewBook;

public class NormalUser extends User {
    private IOOperation[] operations;

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[] {
                new ViewBook(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    public NormalUser(String name, String phoneNumber, String email, String role) {
        super(name, phoneNumber,email, role);
        this.operations = new IOOperation[] {
                new ViewBook(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
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

        System.out.println("Day la menu cua anh/chi "+user.getName());
        System.out.println("------------------------");
        System.out.println("1. Hien Thi Tat Ca Sach ");
        System.out.println("2. Tim Sach Theo Ten");
        System.out.println("3. Dat Sach");
        System.out.println("4. Muon Sach");
        System.out.println("5. Tinh Toan Chi Phi");
        System.out.println("6. Hoan Tra Sach ");
        System.out.println("7. Dang Xuat");

        Scanner scanner = new Scanner(System.in);
        int normalUserChoise = scanner.nextInt();
        this.operations[normalUserChoise - 1].operation(dataBase,user);
        scanner.close();

    }

}
