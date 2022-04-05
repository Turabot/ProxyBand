package com.example.taskmongo.controller;

import com.example.taskmongo.entity.User;
import com.example.taskmongo.dto.UserDto;
import com.example.taskmongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        log.info("Method createUser is worked. The User- {} is created ", userDto.getName());
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        log.info("Method updateUser is worked. The User - {} is update ", userDto.getName());
    }

    @GetMapping("/get-all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto);
        log.info("Method deleteUser is worked. User with this email - {} is deleted", userDto.getEmail());
    }
}
