package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class Search implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Nhap ten sach ban muon tim: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int index = dataBase.getBookIndex(name);
        boolean isBookFound = index != -1;
        if (isBookFound) {
            System.out.println(dataBase.getBook(index).toString());
        } else {
            System.out.println("Khong tim thay sach!!!");
        }
        System.out.println(" ");
        user.menu(dataBase, user);

    }

}
