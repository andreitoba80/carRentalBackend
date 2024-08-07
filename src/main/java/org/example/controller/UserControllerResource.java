package org.example.controller;

import org.example.dto.LoginDto;
import org.example.dto.UpdateUserDto;
import org.example.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
public interface UserControllerResource {

    @PostMapping("createUser")
    ResponseEntity<String> createUser(@RequestBody User user);

    @PostMapping("login")
    ResponseEntity<?> login(@RequestBody LoginDto loginDto);

    @GetMapping("getAllUsers")
    ResponseEntity<?> getAllUsers();

    @PutMapping(value = "updateUser/{userId}")
    ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto updateUserDto);

    @DeleteMapping(value = "deleteUserById/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable Long userId);
}
