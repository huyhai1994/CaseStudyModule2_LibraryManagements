package library.iooperation;

import library.database.DataBase;
import library.user.*;

public class AddBook implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Book Added");
    }
}
