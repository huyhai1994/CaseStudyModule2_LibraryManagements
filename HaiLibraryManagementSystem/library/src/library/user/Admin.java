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
        System.out.println("Day la menu cua Admin");
        System.out.println("-------------------");
        System.out.println("1. Hien Thi Sach");
        System.out.println("2. Them Sach");
        System.out.println("3. Xoa Sach");
        System.out.println("4. Tim Sach");
        System.out.println("5. Xoa Tat Ca Du Lieu");
        System.out.println("6. Xem Giao Dich");
        System.out.println("7. Thoat");

        Scanner scanner = new Scanner(System.in);
        int adminchoise = scanner.nextInt();
        this.operations[adminchoise - 1].operation(dataBase,user);
        scanner.close();

    }

}
