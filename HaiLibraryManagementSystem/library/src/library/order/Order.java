package library.order;

import library.book.Book;
import library.user.User;

public class Order {
   
    private Book book;
    private User user;
    private double price;
    private int quatity;

    public Order() {
    }

    public Order(Book book, User user, double price, int quatity) {
        this.book = book;
        this.user = user;
        this.price = price;
        this.quatity = quatity;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuatity() {
        return this.quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public Order book(Book book) {
        setBook(book);
        return this;
    }

    public Order user(User user) {
        setUser(user);
        return this;
    }

    public Order price(double price) {
        setPrice(price);
        return this;
    }

    public Order quatity(int quatity) {
        setQuatity(quatity);
        return this;
    }

    @Override
    public String toString() {
        return "Ten sach :" + this.book.getTitle() + "\n" +
            "Nguoi muon:" + this.user.getName() + "\n" +
            "Gia: " + String.valueOf(price) + "\n" +
            "So luong: " + String.valueOf(quatity)+"\n";
    }
}
