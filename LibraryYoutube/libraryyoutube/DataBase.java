import java.util.ArrayList;

public class DataBase {

    private ArrayList<User> usersList = new ArrayList<User>();
    private ArrayList<String> usernamesList = new ArrayList<String>();

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
}
