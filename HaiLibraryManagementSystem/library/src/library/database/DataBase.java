package library.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import library.user.*;
import library.book.*;

public class DataBase {
    public static final String USERS_FILE_PATH = "src/library/database/users.txt";
    public static final String BOOKS_FILE_PATH = "src/library/database/books.txt";
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();
    private File usersFile;
    private File booksFile;

    public DataBase() {
        try {
            usersFile = new File(USERS_FILE_PATH);
            booksFile = new File(BOOKS_FILE_PATH);
            boolean usersFileNotExist = !usersFile.exists();
            boolean booksFileNotExist = !booksFile.exists();
            if (usersFileNotExist) {
                usersFile.createNewFile();
            }
            if (booksFileNotExist) {
                booksFile.createNewFile();
            }
            this.readUserInformationsFromFile();
            this.readBookInformationsFromFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser(User user) throws IOException {
        users.add(user);
        usernames.add(user.getName());
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
                System.out.println("User exists!!!");
                indexOfUser = users.indexOf(user);
            }
        }
        return indexOfUser;
    }

    public User getUser(int indexOfUser) {
        return users.get(indexOfUser);
    }

    public void showUsers() {
        System.out.println("Name | PhoneNumber | Email | Role");
        for (User user : users) {
            System.out.println(user);
        }

    }

    public ArrayList<Book> getAllBooks() {
        return books;
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
        System.out.println("Vi tri cua sach " + index);
        System.out.println("Dang xoa sach...");
        books.remove(index);
        // booknames.remove(index);
        System.out.println("da xoa khoi danh sach");
        showBooks();
        try {
            this.writeBookInformationsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBooks() {
        System.out.println(
                "      Tieu De    |  Tac Gia      |     NXB   | Vi Tri | TT | S.Luong | Gia | SLMuon");
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

    private void writeBookInformationsToFile() throws IOException {
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
        books.add(book);
        booknames.add(book.getTitle());
        this.writeBookInformationsToFile();
    }
}
