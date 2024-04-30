package library.iooperation;

import java.util.Scanner;
import library.database.DataBase;
import library.user.*;

public class Exit implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Ban co muon dang xuat tai khoan? \n" + "1.Co, toi dong y\n2.Khong, khong dong y\n");
        Scanner scanner = new Scanner(System.in);
        int userChoise = scanner.nextInt();
        boolean isUserAgree = userChoise == 1;
        boolean isUserDisagree = userChoise == 2;
        if (isUserAgree) {
            try {
             scanner.close();   
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (isUserDisagree) {
            user.menu(dataBase, user);
        }
        user.menu(dataBase, user);
    }
}
