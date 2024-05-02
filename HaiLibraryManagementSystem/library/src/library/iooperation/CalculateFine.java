package library.iooperation;

import java.util.Scanner;
import library.database.DataBase;
import library.user.*;

public class CalculateFine implements IOOperation {
    public static final int MAX_LATE_FINE_PER_DAY_IN_DONGS = 5000;

    @Override
    public void operation(DataBase dataBase, User user) {
        System.out.println("Xin hay nhap tieu de sach: ");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();

        for (Borrowing borrowing : dataBase.getBorrowings()) {
            boolean isInputBorrowingBookTitleMatchesDatabaseStoredBookTitle = borrowing.getBook().getTitle()
                    .equalsIgnoreCase(bookTitle);
            boolean isUserNameMatchesDatabaseStoredUserName = borrowing.getUser().getName()
                    .equalsIgnoreCase(user.getName());
            if (isUserNameMatchesDatabaseStoredUserName &&
                    isInputBorrowingBookTitleMatchesDatabaseStoredBookTitle) {
                checkingAndPrintTheStatusIfBorrowingDaysPassedReturnDays(borrowing.getDaysLeft());
            }
            user.menu(dataBase, user);
        }
    }

    public static void checkingAndPrintTheStatusIfBorrowingDaysPassedReturnDays(int daylefts) {
        boolean isReturnDaysPass = daylefts < 0;
        if (isReturnDaysPass) {
            System.out.println("Ban da cham tra! " +
                    "ban phai tra tien phi cham : " +
                     Math.abs(daylefts) * MAX_LATE_FINE_PER_DAY_IN_DONGS);
        } else {
            System.out.println("Ban khong can phai tra tien phi cham!!!");
        }
    }
}
