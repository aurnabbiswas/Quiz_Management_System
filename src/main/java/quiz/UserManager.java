package quiz;

import java.io.FileReader;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class UserManager {
    private final String USERS_FILE = "users.json";

    public User authenticate(String username, String password) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(USERS_FILE);
            List<User> users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
            reader.close();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading users: " + e.getMessage());
        }
        return null;
    }
}

