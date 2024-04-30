package library.iooperation;
import library.database.DataBase;
import library.user.*;
import java.util.ArrayList;
import library.book.*;

public class ViewBook implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        ArrayList<Book> books = dataBase.getAllBooks();
        System.out.println("Tieu De\tTac Gia\tNXB\tVi Tri\tTT\tS.Luong\tGia\t SLMuon\t");
        for (Book book : books) {
            System.out.println(book.getTitle() + "\t" +
                    book.getAuthor() + "\t" +
                    book.getPublisher() + "\t" +
                    book.getCollectionLocation() + "\t" +
                    book.getBorrowingStatus() + "\t" +
                    book.getQuatity() + "\t" +
                    book.getPrice() + "\t" +
                    book.getBorrowingCopies() + "\t");
        }
        System.out.println(" ");
        user.menu(dataBase, user);
    }

}
