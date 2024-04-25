

public class Book {
    private String bookTitle;
    private String author;
    private String publisher;
    private String collectionLocation;
    private String borrowingStatus;
    private int copiesForSale;
    private int copiesForBorrowing;

    public Book() {
    }

    public Book(String bookTitle, String author,
            String publisher, String collectionLocation,
            String borrowingStatus, int copiesForSale, int copiesForBorrowing) {

        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.collectionLocation = collectionLocation;
        this.borrowingStatus = borrowingStatus;
        this.copiesForSale = copiesForSale;
        this.copiesForBorrowing = copiesForBorrowing;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public int getCopiesForSale() {
        return this.copiesForSale;
    }

    public void setCopiesForSale(int copiesForSale) {
        this.copiesForSale = copiesForSale;
    }

    public int getCopiesForBorrowing() {
        return this.copiesForBorrowing;
    }

    public void setCopiesForBorrowing(int copiesForBorrowing) {
        this.copiesForBorrowing = copiesForBorrowing;
    }

}
