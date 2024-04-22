import java.util.ArrayList;

class Person {
    private ArrayList<Book> borrowedBooks;

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.person = this;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.person = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Borrowed books: ");
        for (Book book : borrowedBooks) {
            sb.append(book.title).append(", ");
        }
        return sb.toString();
    }
}

class Book {
    private String title;
    private Person person;

    public Book(String title) {
        this.title = title;
        this.person = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book other = (Book) obj;
            return this.title.equals(other.title);
        }
        return false;
    }

    @Override
    public String toString() {
        if (person == null) {
            return title;
        } else {
            return title + " (checked out by " + person + ")";
        }
    }
}

class CheckedOutBook {
    private Book book;
    private Person person;

    public CheckedOutBook(Book book, Person person) {
        this.book = book;
        this.person = person;
    }

    void includeBook() {
        // Implementation
    }

    void checkOutBook() {
        // Implementation
    }

    void returnBook() {
        // Implementation
    }
}
