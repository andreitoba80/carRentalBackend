package org.example.service;

import org.example.dto.LoginDto;
import org.example.dto.UpdateUserDto;
import org.example.entity.User;
import org.example.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface UserService {
    void createUser(User user) throws Exception;

    User login(LoginDto loginDto) throws NotFoundException;

    void updateUser(Long userId, UpdateUserDto updateUserDto) throws Exception;

    void deleteUser(Long userId) throws Exception;

    ArrayList<User> getAllUsers();
}
