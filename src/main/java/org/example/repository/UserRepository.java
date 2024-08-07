package org.example.repository;

import org.example.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmailOrUsername(String email, String username);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserById(Long id);

    ArrayList<User> findAll();
}
