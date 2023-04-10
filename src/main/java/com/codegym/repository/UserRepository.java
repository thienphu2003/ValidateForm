package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    User findUserById(Long id);
}
