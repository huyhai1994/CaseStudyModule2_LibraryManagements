import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataBase {

    private ArrayList<User> usersList = new ArrayList<User>();
    private ArrayList<String> usernamesList = new ArrayList<String>();
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<String> booksNameList = new ArrayList<String>();
    private File usersFile = new File(ClassLoader.getSystemResource("Books.txt").getFile());
    private File booksFile = new File(ClassLoader.getSystemResource("Users.txt").getFile());

    public DataBase() {
        if (!usersFile.exists()) {
            usersFile.mkdirs();
        }
        if (!booksFile.exists()) {
            booksFile.mkdirs();
        }
    }

    public void addUser(User user) {
        usersList.add(user);
        usernamesList.add(user.getName());
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
    private void getUsers(){
        String text = " ";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader("Users.txt"));
            br1.close();
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
    
    private void saveUsers(){
        String text1 = " ";
        for (User user : usersList){
            // text1 = text1 + usersList.get

        }
    }
}
