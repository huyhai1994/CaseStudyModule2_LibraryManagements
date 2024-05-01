package library.iooperation;

import java.io.IOException;
import java.util.Scanner;

import library.book.Book;
import library.database.DataBase;
import library.order.Order;
import library.user.*;

public class PlaceOrder implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        Order order = new Order();
        System.out.println("Hay nhap ten sach ban muon dat: ");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        int index = dataBase.getBookIndex(bookTitle);
        boolean isBookNotExist = index <= -1;
        if (isBookNotExist) {
            System.out.println("Sach ban nhap khong co!!!");
        } else {
            Book bookUserOrder = dataBase.getBook(bookTitle);
            order.setBook(bookUserOrder);
            order.setUser(user);
            System.out.println("Hien tai sach " + bookTitle + " con " + bookUserOrder.getQuatity());
            System.out.println("Hay Nhap so luong ban muon dat: ");
            int userPlaceOrderQuatity = scanner.nextInt();
            order.setQuatity(userPlaceOrderQuatity);
            double bookOrderFee = userPlaceOrderQuatity * bookUserOrder.getPrice();
            order.setPrice(bookOrderFee);
            try {
                int bookUserOrderIndex = dataBase.getBookIndex(bookTitle);
                dataBase.addOrder(order, bookUserOrder, bookUserOrderIndex);
                System.out.println("Sach da duoc dat thanh cong...");
                int updateBookUserOrderQuatity = bookUserOrder.getQuatity() - userPlaceOrderQuatity;
                System.out.println("Hien tai sach " + bookTitle + " con " + updateBookUserOrderQuatity);
                bookUserOrder.setQuatity(updateBookUserOrderQuatity);
                dataBase.writeBookInformationsToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        user.menu(dataBase, user);
    }

}
