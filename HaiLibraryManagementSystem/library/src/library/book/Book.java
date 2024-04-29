package library.book;

public class Book {
    private String title;
    private String author;
    private String pulisher;
    private String collectionLocation;
    private String borrowingStatus;
    private int quatity;
    private double price;
    private int borrowingCopies;


    public Book() {
    }

    public Book(String title, String author, String pulisher, String collectionLocation, String borrowingStatus, int quatity, double price, int borrowingCopies) {
        this.title = title;
        this.author = author;
        this.pulisher = pulisher;
        this.collectionLocation = collectionLocation;
        this.borrowingStatus = borrowingStatus;
        this.quatity = quatity;
        this.price = price;
        this.borrowingCopies = borrowingCopies;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPulisher() {
        return this.pulisher;
    }

    public void setPulisher(String pulisher) {
        this.pulisher = pulisher;
    }

    public String getCollectionLocation() {
        return this.collectionLocation;
    }

    public void setCollectionLocation(String collectionLocation) {
        this.collectionLocation = collectionLocation;
    }

    public String getBorrowingStatus() {
        return this.borrowingStatus;
    }

    public void setBorrowingStatus(String borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }

    public int getQuatity() {
        return this.quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBorrowingCopies() {
        return this.borrowingCopies;
    }

    public void setBorrowingCopies(int borrowingCopies) {
        this.borrowingCopies = borrowingCopies;
    }

    
}
