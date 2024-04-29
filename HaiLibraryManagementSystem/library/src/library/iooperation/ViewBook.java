package library.iooperation;

import library.database.DataBase;
import library.user.*;

public class ViewBook implements IOOperation{

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("View Books");
    }
    
}
