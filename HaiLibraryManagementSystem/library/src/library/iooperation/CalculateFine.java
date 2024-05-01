package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class CalculateFine implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Xin hay nhap tieu de sach: ");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        

    }
    
}
