package data;

import java.util.ArrayList;

import model.User;

public class UserDataManager {
    private static UserDataManager instance;
    private ArrayList<User> userList = new ArrayList<>();
   

    public static UserDataManager getInstance() {
        if (instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
