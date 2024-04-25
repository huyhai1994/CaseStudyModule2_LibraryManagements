import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileWriter;

public class DataBase {

    private ArrayList<User> usersList = new ArrayList<User>();
    private ArrayList<String> usernamesList = new ArrayList<String>();
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<String> booksNameList = new ArrayList<String>();
    // private FileWriter usersFile = new FileWriter("Users.txt");
    // private FileWriter booksFile = new FileWriter("Books.txt");
    private FileWriter usersFile;
    private FileWriter booksFile;

    public DataBase() {
        // if (!usersFile.exists()) {
        //     try {
        //         usersFile.createNewFile();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        // if (!booksFile.exists()) {
        //     try {
        //         booksFile.createNewFile();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        try {
            usersFile = new FileWriter("Users.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            booksFile = new FileWriter("Books.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getUsers();
    }

    public void addUser(User user) {
        usersList.add(user);
        usernamesList.add(user.getName());
        saveUsers();
    }

    public int login(String phoneNumber, String email) {
        int locationOfUserInUsersList = -1;
        for (User user : usersList) {
            if (user.getPhoneNumber().matches(phoneNumber) &&
                    user.getEmail().matches(email)) {
                locationOfUserInUsersList = usersList.indexOf(user);
                break;
            }
        }
        return locationOfUserInUsersList;
    }

    public User getUser(int locationOfUser) {
        return usersList.get(locationOfUser);
    }

    public void addBook(Book book) {
        bookList.add(book);
        booksNameList.add(book.getBookTitle());
        
    }

    private void getUsers() {
        String text = " ";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("Users.txt"));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text = text + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        if (!text.matches(" ") || !text.isEmpty()) {
            String[] a1 = text.split("<NewUser/>");
            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2]);
                    usersList.add(user);
                    usernamesList.add(user.getName());
                } else {
                    User user = new NormalUser(a2[0], a2[1], a2[2]);
                    usersList.add(user);
                    usernamesList.add(user.getName());
                }
            }
        }
    }

    private void saveUsers() {
        String text1 = " ";
        for (User user : usersList) {
            text1 = text1 + user.toString() + "<NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(usersFile);
            pw.print(text1);
            pw.close();
            System.out.println("New-User saved successfully!");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
