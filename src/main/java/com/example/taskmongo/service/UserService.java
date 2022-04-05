package com.example.taskmongo.service;

import com.example.taskmongo.entity.User;
import com.example.taskmongo.dto.UserDto;
import com.example.taskmongo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(UserDto userDto){
        userRepository.save(new User(
                userDto.getEmail(),
                userDto.getName()
        ));
    }

    @Transactional
    public void updateUser(UserDto userDto){
        User user = userRepository.findById(userDto.getEmail()).orElseThrow();
        user.setName(userDto.getName());
    }

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
       return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(UserDto userDto) {
        userRepository.deleteById(userDto.getEmail());
    }
}
