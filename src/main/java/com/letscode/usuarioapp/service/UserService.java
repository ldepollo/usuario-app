package com.letscode.usuarioapp.service;

import com.letscode.usuarioapp.domain.User;
import com.letscode.usuarioapp.dto.UserRequestDto;
import com.letscode.usuarioapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> {
            throw new RuntimeException("There is no user with this name");
        });
    }

    public User addUser(UserRequestDto userRequestDto) {
        if(userRepository.existsByName(userRequestDto.getName())) {
            throw new RuntimeException("There is already an user with this name");
        }

        User user = new User(userRequestDto.getName(),
                userRequestDto.getPassword());

        userRepository.save(user);
        return user;
    }

    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow(() -> {
            throw new RuntimeException("There is no user with this name");
        });

        userRepository.delete(user);
    }
}
