package org.example.instazam.repository;

import org.example.instazam.model.User;

public class UserRepository extends BaseRepository<User> {
    private UserRepository() {
        path += "/users.json";
    }
    private static UserRepository userRepository = new UserRepository();
    public static UserRepository getInstance(){
        return userRepository;
    }

    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<User> getTypeClass() {
        return User.class;
    }
}
