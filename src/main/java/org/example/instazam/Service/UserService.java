package org.example.instazam.Service;

import org.example.instazam.excaption.DataNotFoundExcaption;
import org.example.instazam.model.User;
import org.example.instazam.repository.UserRepository;

import java.util.ArrayList;
import java.util.Objects;

public class UserService extends BaseService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
    public User register(User user){
        return save(user);
    }
    public User login(String username, String password){
        ArrayList<User> all = getAll();
        for (User user : all) {
            if (Objects.equals(user.getUsername(),(username)) && Objects.equals(user.getPassword(),(password))) return user;
        }
        throw  new DataNotFoundExcaption("User not found");
    }

    @Override
    protected User updateT(User user, User ut) {
        return User.update(user,ut);
    }
}
