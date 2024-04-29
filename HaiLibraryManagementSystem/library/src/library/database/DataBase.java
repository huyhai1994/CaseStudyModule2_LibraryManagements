package library.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import library.user.*;

public class DataBase {
    public static String USERS_FILE_PATH = "src/library/database/users.txt";
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private File usersFile;

    public DataBase() {
        try {
            usersFile = new File(USERS_FILE_PATH);
            boolean usersFileNotExist = !usersFile.exists();
            if (usersFileNotExist) {
                usersFile.createNewFile();
            }
            this.readUserInformationsFromFile();
            this.showUsers();
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
                    } else if(roleUser.equalsIgnoreCase("normaluser")){
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

}
