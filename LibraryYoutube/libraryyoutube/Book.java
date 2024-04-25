
public class Book {
    private String bookTitle;
    private String author;
    private String publisher;
    private String collectionLocation;
    private String quantity;
    private int price;
    private int copiesForBorrowing;

    public Book() {
    }

    public Book(String bookTitle, String author, String publisher, String collectionLocation, String quantity,
            int price, int copiesForBorrowing) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.collectionLocation = collectionLocation;
        this.quantity = quantity;
        this.price = price;
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

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCopiesForBorrowing() {
        return this.copiesForBorrowing;
    }

    public void setCopiesForBorrowing(int copiesForBorrowing) {
        this.copiesForBorrowing = copiesForBorrowing;
    }

    public Book bookTitle(String bookTitle) {
        setBookTitle(bookTitle);
        return this;
    }

    public Book author(String author) {
        setAuthor(author);
        return this;
    }

    public Book publisher(String publisher) {
        setPublisher(publisher);
        return this;
    }

    public Book collectionLocation(String collectionLocation) {
        setCollectionLocation(collectionLocation);
        return this;
    }

    public Book quantity(String quantity) {
        setQuantity(quantity);
        return this;
    }

    public Book price(int price) {
        setPrice(price);
        return this;
    }

    public Book copiesForBorrowing(int copiesForBorrowing) {
        setCopiesForBorrowing(copiesForBorrowing);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " Book Title    : " + getBookTitle() + "'" +
                " Book Author   :" + getAuthor() + "'" +
                " Book Publisher: " + getPublisher() + "'" +
                " Book collection Location :" + getCollectionLocation() + "'" +
                " Quantity      :'" + getQuantity() + "'" +
                " Price: '" + getPrice() + "'" +
                ", Borrowing Copies: " + getCopiesForBorrowing() + "'" +
                "}";
    }
}
