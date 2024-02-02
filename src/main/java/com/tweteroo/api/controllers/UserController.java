package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserServise;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    final UserServise userService;
    UserController(UserServise userServise){
        this.userService = userServise;
    }

    @GetMapping
    public List getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public Optional<UserModel> setUser(@RequestBody @Valid UserDTO body) {
        Optional<UserModel> user = userService.save(body);
        return user;
    }
    
}
