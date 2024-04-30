package library.iooperation;

import java.time.LocalDate;
import java.time.Period;

import library.book.Book;
import library.user.User;
public class Borrowing {
    public static final int MAX_DAY_TO_BORROW = 14;
    private LocalDate startingDate;
    private LocalDate finishingDate;
    private int daysLeft;
    private Book book;
    private User user;

    public Borrowing() {
    }

    public Borrowing(Book book, User user) {
        this.startingDate = LocalDate.now();
        this.finishingDate = startingDate.plusDays(MAX_DAY_TO_BORROW);
        Period period = Period.between(startingDate, finishingDate);
        this.daysLeft = period.getDays();
        this.book = book;
        this.user = user;
    }

    public LocalDate getStartingDate() {
        return this.startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getFinishingDate() {
        return this.finishingDate;
    }

    public void setFinishingDate(LocalDate finishingDate) {
        this.finishingDate = finishingDate;
    }

    public int getDaysLeft() {
        return this.daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Borrowing startingDate(LocalDate startingDate) {
        setStartingDate(startingDate);
        return this;
    }

    public Borrowing finishingDate(LocalDate finishingDate) {
        setFinishingDate(finishingDate);
        return this;
    }

    public Borrowing daysLeft(int daysleft) {
        setDaysLeft(daysleft);
        return this;
    }

    public Borrowing book(Book book) {
        setBook(book);
        return this;
    }

    public Borrowing user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " startingDate='" + getStartingDate() + "'" +
            ", finishingDate='" + getFinishingDate() + "'" +
            ", daysleft='" + getDaysLeft() + "'" +
            ", book='" + getBook() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
}