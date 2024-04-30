package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class DeleteBook implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tieu de sach de xoa: ");
        String bookName = scanner.next();
        int index = dataBase.getIndexOfBook(bookName);
        boolean isBookFound = index!=-1;
        if (isBookFound) {
            System.out.println("xin chao!!!!");
            dataBase.deleteBook(index);
            System.out.println("Sach da duoc xoa thanh cong");
        } else{
            System.out.println("Khong tim thay sach!!!");
        }
        System.out.println(" ");
        scanner.close();
        user.menu(dataBase, user);
    }
    
}
