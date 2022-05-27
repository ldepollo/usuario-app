package com.letscode.usuarioapp.controller;

import com.letscode.usuarioapp.domain.User;
import com.letscode.usuarioapp.dto.UserRequestDto;
import com.letscode.usuarioapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> userExistsByName(@PathVariable("name") String name) {
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user.getName());
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.addUser(userRequestDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteUserBySku(@PathVariable("name") String name) {
        userService.deleteUser(name);
        return ResponseEntity.ok().build();
    }
}
