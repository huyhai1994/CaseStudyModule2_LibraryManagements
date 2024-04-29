package library.iooperation;

import library.database.DataBase;
import library.user.*;
public interface IOOperation {
    public void operation(DataBase dataBase, User user);
}
