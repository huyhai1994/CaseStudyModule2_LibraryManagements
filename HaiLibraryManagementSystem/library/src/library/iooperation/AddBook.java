package library.iooperation;

import java.io.IOException;
import java.util.Scanner;

import library.database.DataBase;
import library.book.*;
import library.user.*;

public class AddBook implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin moi nhap tieu de sach: ");
        book.setTitle(scanner.next());
        System.out.println("Xin moi nhap ten tac gia: ");
        book.setAuthor(scanner.next());
        System.out.println("Xin moi nhap Nha Xuat Ban(): ");
        book.setPulisher(scanner.next());
        System.out.println("Tinh trang sach: ");
        book.setBorrowingStatus(scanner.next());
        System.out.println("Xin moi nhap vi tri luu tru: ");
        book.setCollectionLocation(scanner.next());
        System.out.println("Xin moi nhap so luong sach [quyen]: ");
        book.setQuatity(scanner.nextInt());
        System.out.println("Xin moi nhap gia [VND]: ");
        book.setPrice(scanner.nextDouble());   
        System.out.println("Xin moi nhap so sach dang cho muon[quyen]: ");
        book.setBorrowingCopies(scanner.nextInt());
        try {
            dataBase.addBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();

        System.out.println("Them sach thanh cong!!!");
    }
}
