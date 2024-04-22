import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private List<CheckedOutBook> books;

    public Person() {
        books = new ArrayList<>();
    }

    public boolean equals(Person pn) {
        return name.equals(pn.name);
    }
}

class Book {
    private String title;
    private Person person;

    public Book() {
        person = null;
    }

    public boolean equals(Book bk) {
        return title.equals(bk.title);
    }
}

class Author {
    private String name;
    private List<Book> books;

    public Author() {
        books = new ArrayList<>();
    }

    public boolean equals(Author ar) {
        return name.equals(ar.name);
    }
}

class CheckedOutBook {
    private Author author;
    private Book book;

    public CheckedOutBook(Author ar, Book bk) {
        author = ar;
        book = bk;
    }

    public boolean equals(CheckedOutBook bk) {
        return author.equals(bk.author) && book.equals(bk.book);
    }
}

public class Main {
    private static List<Author>[] catalog;
    private static List<Person>[] people;

    public static void main(String[] args) {
        catalog = new ArrayList['Z' + 1];
        people = new ArrayList['Z' + 1];

        while (true) {
            switch (menu()) {
                case 1:
                    includeBook();
                    break;
                case 2:
                    checkOutBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    status();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter one of the following options: ");
        System.out.println("1. Include a book in the catalog");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. Status");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        return option;
    }

    private static void includeBook() {
        Scanner scanner = new Scanner(System.in);
        Author newAuthor = new Author();
        Book newBook = new Book();
        System.out.print("Enter author's name: ");
        newAuthor.setName(scanner.nextLine());
        System.out.print("Enter book's title: ");
        newBook.setTitle(scanner.nextLine());
        List<Author> oldAuthor = findIt(catalog[newAuthor.getName().charAt(0)], newAuthor);
        if (oldAuthor == null) {
            newAuthor.getBooks().add(newBook);
            catalog[newAuthor.getName().charAt(0)].add(newAuthor);
        } else {
            oldAuthor.get(0).getBooks().add(newBook);
        }
    }

    private static void checkOutBook() {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        Author author = new Author();
        Book book = new Book();
        List<Author> authorRef;
        List<Book> bookRef;
        System.out.print("Enter person's name: ");
        person.name = scanner.nextLine();
        while (true) {
            System.out.print("Enter author's name: ");
            author.name = scanner.nextLine();
            authorRef = findIt(catalog[author.name.charAt(0)], author);
            if (authorRef == null) {
                System.out.println("Misspelled author's name.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter book's title: ");
            book.title = scanner.nextLine();
            bookRef = findIt(authorRef.get(0).books, book);
            if (bookRef == null) {
                System.out.println("Misspelled book's title.");
            } else {
                break;
            }
        }
        List<Person> personRef = findIt(people[person.name.charAt(0)], person);
        CheckedOutBook checkedOutBook = new CheckedOutBook(authorRef.get(0), bookRef.get(0));
        if (personRef == null) {
            person.books.add(checkedOutBook);
            people[person.name.charAt(0)].add(person);
            bookRef.get(0).person = people[person.name.charAt(0)].get(0);
        } else {
            personRef.get(0).books.add(checkedOutBook);
            bookRef.get(0).person = personRef.get(0);
        }
    }

    private static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        Book book = new Book();
        Author author = new Author();
        List<Person> personRef;
        List<Book> bookRef;
        List<Author> authorRef;
        while (true) {
            System.out.print("Enter person's name: ");
            person.name = scanner.nextLine();
            personRef = findIt(people[person.name.charAt(0)], person);
            if (personRef == null) {
                System.out.println("Misspelled person's name.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter Author Name: ");
            author.name = scanner.nextLine();
            authorRef = findIt(catalog[author.name.charAt(0)], author);
            if (authorRef == null) {
                System.out.println("Mispelled Author Name.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter the title of the book: ");
            book.title = scanner.nextLine();
            bookRef = findIt(authorRef.get(0).books, book);
            if (bookRef == null) {
                System.out.println("Misspelled title.");
            } else {
                break;
            }
        }
        CheckedOutBook checkedOutBook = new CheckedOutBook(authorRef.get(0), bookRef.get(0));
        bookRef.get(0).person = null;
        personRef.get(0).books.remove(checkedOutBook);
    }

    private static void status() {
        System.out.println("Library has the following books: \n");
        for (int i = 'A'; i <= 'Z'; i++) {
            if (catalog[i] != null && !catalog[i].isEmpty()) {
                for (Author author : catalog[i]) {
                    System.out.println(author);
                }
            }
        }
        System.out.println("\nThe following people are using library: \n");
        for (int i = 'A'; i <= 'Z'; i++) {
            if (people[i] != null && !people[i].isEmpty()) {
                for (Person person : people[i]) {
                    System.out.println(person);
                }
            }
        }
    }

    private static <T> List<T> findIt(List<T> lst, T e1) {
        for (T ref : lst) {
            if (ref.equals(e1)) {
                return lst;
            }
        }
        return null;
    }
}
