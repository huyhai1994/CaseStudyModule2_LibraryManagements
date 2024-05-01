package library.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import library.user.Admin;
import library.user.NormalUser;
import library.user.User;
import library.book.Book;
import library.iooperation.Borrowing;
import library.order.Order;

public class DataBase {
    public static final String USERS_FILE_PATH = "src/library/database/users.txt";
    public static final String BOOKS_FILE_PATH = "src/library/database/books.txt";
    public static final String ORDERS_FILE_PATH = "src/library/database/orders.txt";
    public static final String BORROWINGS_FILE_PATH = "src/library/database/borrowings.txt";

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Borrowing> borrowings = new ArrayList<Borrowing>();

    private File usersFile;
    private File booksFile;
    private File ordersFile;
    private File borrowingsFile;

    public DataBase() {
        try {
            usersFile = new File(USERS_FILE_PATH);
            booksFile = new File(BOOKS_FILE_PATH);
            ordersFile = new File(ORDERS_FILE_PATH);

            boolean usersFileNotExist = !usersFile.exists();
            boolean booksFileNotExist = !booksFile.exists();
            boolean ordersFileNotExist = !ordersFile.exists();
            boolean borrowingsFileNotExist = !borrowingsFile.exists();

            if (usersFileNotExist) {
                usersFile.createNewFile();
            }
            if (booksFileNotExist) {
                booksFile.createNewFile();
            }
            if (ordersFileNotExist) {
                ordersFile.createNewFile();
            }
            if (borrowingsFileNotExist) {
                borrowingsFile.createNewFile();
            }

            this.readUserInformationsFromFile();
            this.readBookInformationsFromFile();
            this.readOrderInformationsFromFile();
            this.readBorrowingInformationsFromFile();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser(User user) throws IOException {
        this.users.add(user);
        this.usernames.add(user.getName());
        this.writeUserInformationsToFile();
    }

    public int checkLogin(String phoneNumber, String email) {
        int flag = -1;
        int indexOfUser = flag;
        for (User user : users) {
            String userPhoneNumber = user.getPhoneNumber();
            String userEmail = user.getEmail();
            boolean isInputPhoneNumberMatchedWithDataBaseUser = userPhoneNumber.equalsIgnoreCase(phoneNumber);
            boolean isInputEmailMatchedWithDataBaseUser = userEmail.equalsIgnoreCase(email);

            if (isInputEmailMatchedWithDataBaseUser &&
                    isInputPhoneNumberMatchedWithDataBaseUser) {
                System.out.println("Tai Khoan ton tai!!!");
                indexOfUser = users.indexOf(user);
            }
        }
        return indexOfUser;
    }

    public User getUser(int indexOfUser) {
        return this.users.get(indexOfUser);
    }

    public User getUser(String userName) {

        for (User user : users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                return user;
            }
        }
        return null;
    }

    public void showUsers() {
        System.out.println("   Ten   |      SDT    |      Email    | Vai Tro");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public ArrayList<Book> getAllBooks() {
        return this.books;
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }

    public Book getBook(String bookTitle) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public int getBookIndex(String bookTitle) {
        int index = -1;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                index = books.indexOf(book);
            }
        }
        return index;
    }

    public int getIndexOfBook(String bookName) {
        int index = -1;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                index = books.indexOf(book);
                System.out.println(index);
            }
        }
        return index;
    }

    public void deleteBook(int index) {
        this.books.remove(index);
        this.booknames.remove(index);
        try {
            this.writeBookInformationsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllData() {
        if (usersFile.exists()) {
            try {
                usersFile.delete();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (booksFile.exists()) {
            try {
                booksFile.delete();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (ordersFile.exists()) {
            try {
                ordersFile.delete();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createNewDataFile() {
        try {
            usersFile.createNewFile();
            booksFile.createNewFile();
            ordersFile.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBooks() {
        System.out.println(
                "Tieu De|Tac Gia|NXB| Vi Tri |TT|S.Luong|Gia| SLMuon");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void readUserInformationsFromFile() {
        try {
            FileReader fileReader = new FileReader(USERS_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] txt = line.split(",");
                    String nameUser = txt[0];
                    String phoneUser = txt[1];
                    String emailUser = txt[2];
                    String roleUser = txt[3];
                    if (roleUser.equalsIgnoreCase("admin")) {
                        User userExtractFromFile = new Admin(nameUser, phoneUser, emailUser, roleUser);
                        this.users.add(userExtractFromFile);
                        this.usernames.add(userExtractFromFile.getName());
                    } else if (roleUser.equalsIgnoreCase("normaluser")) {
                        User userExtractFromFile = new NormalUser(nameUser, phoneUser, emailUser, roleUser);
                        this.users.add(userExtractFromFile);
                    }

                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeUserInformationsToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(USERS_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            for (User user : users) {
                String line = user.getName() + "," +
                        user.getPhoneNumber() + "," +
                        user.getEmail() + "," +
                        user.getRole();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readBookInformationsFromFile() {
        try {
            FileReader fileReader = new FileReader(BOOKS_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    Book bookExtractFromFile = parseBook(line);
                    bookExtractFromFile.toString();
                    this.books.add(bookExtractFromFile);
                    this.booknames.add(bookExtractFromFile.getTitle());
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Book parseBook(String line) {
        String[] text = line.split(",");
        String title = text[0];
        String author = text[1];
        String publisher = text[2];
        String collectionLocation = text[3];
        String borrowingStatus = text[4];
        String quatity = text[5];
        String price = text[6];
        String borrowingCopies = text[7];
        Book bookExtractFromFile = new Book(title, author, publisher,
                collectionLocation, borrowingStatus, Integer.parseInt(quatity),
                Double.parseDouble(price), Integer.parseInt(borrowingCopies));
        return bookExtractFromFile;
    }

    public void writeBookInformationsToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(BOOKS_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            for (Book book : books) {
                String line = book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getPublisher() + "," +
                        book.getCollectionLocation() + "," +
                        book.getBorrowingStatus() + "," +
                        book.getQuatity() + "," +
                        book.getPrice() + "," +
                        book.getBorrowingCopies();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Book book) throws IOException {
        this.books.add(book);
        this.booknames.add(book.getTitle());
        this.writeBookInformationsToFile();
    }

    public void addOrder(Order order, Book book, int bookIndex) throws IOException {
        orders.add(order);
        books.set(bookIndex, book);
        this.writeOrderInformationToFile();
    }

    public void writeOrderInformationToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(ORDERS_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            for (Order order : orders) {
                String line = order.getBook().getTitle() + "," +
                        order.getUser().getName() + "," +
                        order.getPrice() + "," +
                        order.getQuatity();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readOrderInformationsFromFile() {
        try {
            FileReader fileReader = new FileReader(ORDERS_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    Order orderExtractFromFile = parseOrder(line);
                    this.orders.add(orderExtractFromFile);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Order parseOrder(String line) {
        String[] txt = line.split(",");
        String bookName = txt[0];
        String userName = txt[1];
        String price = txt[2];
        String quatity = txt[3];
        Book book = this.getBook(bookName);
        User user = this.getUser(userName);
        Order orderExtractFromFile = new Order(book, user,
                Double.parseDouble(price),
                Integer.parseInt(quatity));
        return orderExtractFromFile;
    }

    public void showOrders() {
        System.out.println();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    public void writeBorrowingInformationToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(BORROWINGS_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            for (Borrowing borrowing : borrowings) {
                String line = borrowing.getStart() + "," +
                        borrowing.getFinish() + "," +
                        borrowing.getBook().getTitle() + "," +
                        borrowing.getUser().getName();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readBorrowingInformationsFromFile() {
        try {
            FileReader fileReader = new FileReader(BORROWINGS_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try {

                while ((line = bufferedReader.readLine()) != null) {
                    Borrowing borrowingExtractFromFile = parseBorrowing(line);
                    this.borrowings.add(borrowingExtractFromFile);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Borrowing parseBorrowing(String line) {
        String[] txt = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startingDate = LocalDate.parse(txt[0], formatter);
        LocalDate finishingDate = LocalDate.parse(txt[1], formatter);
        String bookName = txt[2];
        String userName = txt[3];
        Book book = this.getBook(bookName);
        User user = this.getUser(userName);
        Borrowing borrowingExtractFromFile = new Borrowing(startingDate, finishingDate, book, user);
        return borrowingExtractFromFile;
    }

    public void borrowingBook(Borrowing borrowing, Book book, int bookIndex) {
        borrowings.add(borrowing);
        books.set(bookIndex,book);
        try {
            this.writeBorrowingInformationToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.writeBookInformationsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Borrowing> getBorrowings(){
        return borrowings;
    }
}
