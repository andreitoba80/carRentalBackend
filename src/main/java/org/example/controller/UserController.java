package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.LoginDto;
import org.example.dto.UpdateUserDto;
import org.example.entity.User;
import org.example.exception.NoSuchEntityException;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.example.utils.Security.encryptPassword;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController implements UserControllerResource {

    private UserService userService;

    @Override
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
//            user.setPassword(encryptPassword(user.getPassword()));
            userService.createUser(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }
        return ResponseEntity.status(200).body("User Created Successfully!");
    }

    @Override
    public ResponseEntity<?> login(LoginDto loginDto) {
        try {
            loginDto.setPassword(encryptPassword(loginDto.getPassword()));
            User loggedUser = userService.login(loginDto);
            return ResponseEntity.status(200).body(loggedUser);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        try {
            var allUsers = userService.getAllUsers();
            return ResponseEntity.status(200).body(allUsers);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }
    }

    @Override
    public ResponseEntity<String> updateUser(Long userId, UpdateUserDto updateUserDto) {
        try {
            userService.updateUser(userId, updateUserDto);
        } catch (NoSuchEntityException e) {
            return ResponseEntity.status(400).body("User does not exist...");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("There was an error while updating the user.");
        }
        return ResponseEntity.status(200).body("User has been updated successfully!");
    }

    @Override
    public ResponseEntity<String> deleteUserById(Long userId) {
        try {
            userService.deleteUser(userId);
        } catch (NoSuchEntityException e) {
            return ResponseEntity.status(400).body("User does not exist");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("There was an error while deleting the user");
        }
        return ResponseEntity.status(200).body("User has been deleted successfully");
    }
}
