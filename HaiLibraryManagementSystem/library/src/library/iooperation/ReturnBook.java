package library.iooperation;

import java.util.Scanner;

import library.book.Book;
import library.database.DataBase;
import library.user.*;

public class ReturnBook implements IOOperation {
    public static final int MAX_LATE_FINE_PER_DAY_IN_DONGS = 5000;

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Nhap tieu de sach ban muon tra: ");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        boolean isThereHasBorrowingBooks = !dataBase.getBorrowings().isEmpty();

        if (isThereHasBorrowingBooks) {
            for (Borrowing borrowing : dataBase.getBorrowings()) {
                if (checkingIfTheBookTitleInBorrowingsMatchWithInputBookTitle(borrowing, bookTitle) &&
                        checkingIfUserNameInBorrowingsMatchUserInDataBase(user.getName(),
                                borrowing.getBook().getTitle())) {
                    int borrowingDaysPassed = borrowing.getDaysLeft();
                    Book book = borrowing.getBook();
                    int bookIndex = dataBase.getAllBooks().indexOf(book);
                   
                    if (checkReturnDaysPassed(borrowingDaysPassed)){
                        printFineStatusIfReturnDaysPassed(borrowingDaysPassed);
                    }

                    book.setBorrowingCopies(book.getBorrowingCopies() + 1);
                    dataBase.returnBook(borrowing, book, bookIndex);
                    printBookReturnedSuccesfully();
                    break;

                } else{
                    printUserDidntBorrowTheBook();
                }
                user.menu(dataBase, user);
            }
        }
    }

    private boolean checkingIfTheBookTitleInBorrowingsMatchWithInputBookTitle(Borrowing borrowing, String bookTitle) {
        return borrowing.getBook().getTitle().equalsIgnoreCase(bookTitle);
    }

    private boolean checkingIfUserNameInBorrowingsMatchUserInDataBase(String UserDatabaseName, String UserBorrowings) {
        return UserDatabaseName.equalsIgnoreCase(UserBorrowings);
    }

    private boolean checkReturnDaysPassed(int daylefts) {
        return daylefts < 0;
    }

    private void printFineStatusIfReturnDaysPassed(int daylefts) {
        System.out.println("Ban da cham tra! " +
                "ban phai tra tien phi cham : " +
                Math.abs(daylefts) * MAX_LATE_FINE_PER_DAY_IN_DONGS);
    }

    private void printBookReturnedSuccesfully() {
        System.out.println("Sach da duoc hoan tra \n Xin cam on dung dich vu...");
    }
    private void printUserDidntBorrowTheBook(){
        System.out.println("Ban khong muon quyen sach nay...");
    }
}
