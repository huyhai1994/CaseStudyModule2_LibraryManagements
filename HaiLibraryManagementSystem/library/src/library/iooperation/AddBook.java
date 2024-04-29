package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class AddBook implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin moi nhap tieu de sach: ");
        System.out.println("Book Added");
    }
}
