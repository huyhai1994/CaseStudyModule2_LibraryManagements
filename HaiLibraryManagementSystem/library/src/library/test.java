package library;
import java.io.File;
import java.io.IOException;
import library.database.DataBase;
public class test {
    public static void main(String[] args) throws IOException {
        String BOOKS_FILE_PATH = "src/library/database/books.txt";
        File file = new File(BOOKS_FILE_PATH);
        System.out.println("book file exist = " + file.exists());
        System.out.println(" book file can write = " + file.canWrite());
        System.out.println(" book file can read = " + file.canRead());
        DataBase dataBase = new DataBase();
        dataBase.getAllBooks();
        dataBase.showBooks();
        dataBase.deleteBook(5);
        dataBase.showBooks();
    }
}
