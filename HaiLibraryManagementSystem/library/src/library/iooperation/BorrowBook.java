package library.iooperation;
import java.util.Scanner;

import library.book.Book;
import library.database.DataBase;
import library.user.*;

public class BorrowBook implements IOOperation {

    @Override
    public void operation(DataBase dataBase, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tieu de sach de muon: ");
        String bookName = scanner.next();
        int index = dataBase.getIndexOfBook(bookName);
        boolean isBookFound = index != -1;
        if (isBookFound) 
        {
            Book book = dataBase.getBook(index);
            boolean isBookCouldBeBorrowed = book.getBorrowingCopies()>1;
            if (isBookCouldBeBorrowed) {
                Borrowing borrowing = new Borrowing(book,user);
                book.setBorrowingCopies(book.getBorrowingCopies()-1);
                dataBase.borrowingBook(borrowing,book,index);
                System.out.println("Sach da duoc muon thanh cong");
                System.out.println("ban phai tra lai sach trong \nthoi gian 14 ngay tinh tu ngay hom nay..."+
                "Ngay hoan tra: " + borrowing.getFinish());
            } else{
                System.out.println("Quyen sach nay khong con de muon nua...");
            }
           
        } else {
            System.out.println("Khong tim thay sach!!!");
        }
        System.out.println(" ");
        user.menu(dataBase, user);
    }

}
