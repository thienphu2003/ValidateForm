package com.codegym.services;

import com.codegym.model.User;

public interface IUserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void delete (Long id);

}
