package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.order.Order;
import library.user.*;

public class ViewOrders implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tieu de sach: ");
        String bookTitle = scanner.next();
        int index = dataBase.getIndexOfBook(bookTitle);
        boolean isBookFound = index != -1;
        if (isBookFound) {
            for (Order order : dataBase.getAllOrders()) {
                if (order.getBook().getTitle().equalsIgnoreCase(bookTitle)) {
                    System.out.println(order.getBook().getTitle() + "," + 
                                        order.getUser() + "," + 
                                        order.getQuatity()+ "," +
                                         order.getPrice());
                }
            }
        } else {
            System.out.println("Khong tim thay sach!!!");
        }
        System.out.println(" ");
        user.menu(dataBase, user);
    }

}
