package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import library.book.Book;

import library.database.DataBase;

public class test {
    public static void main(String[] args) throws IOException {
        String USERS_FILE_PATH = "src/library/database/users.txt";
        String BOOKS_FILE_PATH = "src/library/database/books.txt";
        File file = new File(BOOKS_FILE_PATH);
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("book file exist = " + file.exists());
        System.out.println(" book file can write = " + file.canWrite());
        System.out.println(" book file can read = " + file.canRead());
        DataBase dataBase = new DataBase();
        Book book = new Book("An Uong Noi Cuoi",
                "Tran Huyen An", "NXB tre", "VH", "true",
                10, 58000.0, 2);
        dataBase.addBook(book);
        dataBase.readBookInformationsFromFile();
        dataBase.showBooks();

    }
}
