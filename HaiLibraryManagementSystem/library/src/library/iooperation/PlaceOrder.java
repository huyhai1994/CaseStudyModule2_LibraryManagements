package library.iooperation;

import java.util.Scanner;

import library.book.Book;
import library.database.DataBase;
import library.order.Order;
import library.user.*;

public class PlaceOrder implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        Order order = new Order();
        System.out.println("Hay nhap ten sach ban muon dat: ");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        int index = dataBase.getBookIndex(bookTitle);
        boolean  isBookNotExist = index<=-1;
        if (isBookNotExist) {
            System.out.println("Sach ban nhap trong co!!!");
        } else{
            Book bookUserOrder = dataBase.getBook(bookTitle);
            order.setBook(bookUserOrder);
            order.setUser(user);
            System.out.println("Hien tai sach "+bookTitle+" con "+ bookUserOrder.getQuatity());
            System.out.println("Hay Nhap so luong ban muon dat: ");
            
            // order.setQuatity(quantity);

        }

    }
    
}
