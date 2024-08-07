package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.LoginDto;
import org.example.dto.UpdateUserDto;
import org.example.entity.User;
import org.example.exception.EntityAlreadyExistsException;
import org.example.exception.NoSuchEntityException;
import org.example.exception.NotFoundException;
import org.example.repository.UserRepository;
import org.example.utils.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.example.utils.Security.encryptPassword;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Override
    public void createUser(User user) throws Exception {
        try {
            if (userRepository.findUserByEmailOrUsername(user.getEmail(), user.getUsername()) == null) {
                user.setPassword(encryptPassword(user.getPassword()));
                userRepository.save(user);
            } else {
                throw new EntityAlreadyExistsException(user.getClass().getSimpleName());
            }
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public User login(LoginDto loginDto) throws NotFoundException {
        var logginUser = userRepository.findUserByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (logginUser != null) {
            LoggedUser loggedUser = LoggedUser.getInstance();
            loggedUser.setUsername(logginUser.getUsername());
            loggedUser.setPassword(logginUser.getPassword());
            loggedUser.setIsAdmin(logginUser.getIsAdmin());
            return logginUser;
        }
        throw new NotFoundException(User.class.getName());
    }

    @Override
    public void updateUser(Long userId, UpdateUserDto updateUserDto) throws Exception {
        var userData = userRepository.findUserById(userId);
        if (userData != null) {
            userData.setUsername(updateUserDto.getUsername());
            userData.setEmail(updateUserDto.getEmail());
            userData.setFullName(updateUserDto.getFullName());
            userData.setIsAdmin(updateUserDto.getIsAdmin());
            userData.setPassword(encryptPassword(updateUserDto.getPassword()));

            userRepository.save(userData);
        } else {
            throw new NoSuchEntityException("User");
        }
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        var userData = userRepository.findUserById(userId);
        if (userData != null) {
            userRepository.delete(userData);
        } else throw new NoSuchEntityException("User");
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return userRepository.findAll();
    }
}
