package data;

import java.sql.SQLException;
import java.util.ArrayList;


import model.User;

public class UserDataManager {
    private static UserDataManager instance;
    private ArrayList<User> userList = new ArrayList<>();
    private static OracleDBConnection dbManager = new OracleDBConnection();


    public static UserDataManager getInstance() {
        if (instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        if (userList.isEmpty()) {
        	getUsersFromDatabase();  // Load from database if list is empty
        }
        return userList;
    }

    private void getUsersFromDatabase() {
        try {
            ArrayList<User> usersFromDb = dbManager.fetchUsers();
            userList.clear();
            userList.addAll(usersFromDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addUser(User user) {
        userList.add(user);
    }
}
