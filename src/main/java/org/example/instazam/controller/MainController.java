package org.example.instazam.controller;

import org.example.instazam.model.User;
import org.example.instazam.repository.UserRepository;

public class MainController {
    public static void main(String[] args) {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.save(new User("b","b","b","0320"));
        System.out.println(userRepository.readAll());
    }
}
