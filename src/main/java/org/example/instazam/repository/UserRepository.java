package org.example.instazam.repository;

import org.example.instazam.model.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepository extends BaseRepository<User> {
    private UserRepository() {
        path += "/users.json";
    }
    private static UserRepository userRepository = new UserRepository();
    public static UserRepository getInstance(){
        return userRepository;
    }

    @Override
    protected boolean hasModel(User u) {
        ArrayList<User> users = readAll();
        for (User user : users) {
            if (Objects.equals(user.getUsername(),u.getUsername())
            || Objects.equals(user.getEmail(),u.getEmail())) return true;
        }
        return false;
    }

    @Override
    protected Class<User> getTypeClass() {
        return User.class;
    }
}
