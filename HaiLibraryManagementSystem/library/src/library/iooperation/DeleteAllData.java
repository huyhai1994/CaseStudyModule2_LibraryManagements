package library.iooperation;

import java.util.Scanner;

import library.database.DataBase;
import library.user.*;

public class DeleteAllData implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Ban chac chan muon xoa het du lieu? \n" + "1.Co, toi dong y\n2.Khong, khong dong y\n");
        Scanner scanner = new Scanner(System.in);
        int userChoise = scanner.nextInt();
        boolean isUserAgree = userChoise == 1;
        boolean isUserDisagree = userChoise == 2;
        if (isUserAgree) {
            dataBase.deleteAllData();
            dataBase.createNewDataFile();
        } else if (isUserDisagree) {
            user.menu(dataBase, user);
        }
        user.menu(dataBase, user);
    }
}
