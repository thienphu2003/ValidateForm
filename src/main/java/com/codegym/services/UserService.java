package com.codegym.services;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements  IUserService{


    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }
}
