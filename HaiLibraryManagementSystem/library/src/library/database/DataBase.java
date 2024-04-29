package library.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import library.user.*;

public class DataBase {
    public static String USERS_FILE_PATH = "src/library/database/users.txt";
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private File usersfile;

    public DataBase() {
        
        try {
            usersfile = new File(USERS_FILE_PATH);
            System.out.println("User file exit: "+ usersfile.exists());
             System.out.println("User file can read: "+ usersfile.canRead());
             System.out.println("User file can write: "+ usersfile.canWrite());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser(User user) throws IOException {
        users.add(user);
        usernames.add(user.getName());
        this.writeUserToFile();
    }

    public int checkLogin(String phoneNumber, String email) {
        int flag = -1;
        int indexOfUser = flag;
        for (User user : users) {
            if (user.getPhoneNumber().matches(phoneNumber) &&
                    user.getEmail().matches(email))
                indexOfUser = users.indexOf(user);
            return indexOfUser;
        }
        return indexOfUser;
    }

    public User getUser(int indexOfUser) {
        return users.get(indexOfUser);
    }
    public void showUsers(){
        for(User user : users){
            System.out.println(user);
        }
    }

    private void writeUserToFile() throws IOException{
        FileWriter fileWriter = new FileWriter(USERS_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try{
            for (User user : users){
                String line = user.getName()+","+
                        user.getPhoneNumber()+","+user.getEmail();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
