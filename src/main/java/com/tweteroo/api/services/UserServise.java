package com.tweteroo.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserServise {
    final UserRepository userRepository;
    UserServise(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Optional<UserModel> save(UserDTO dto){
        if(userRepository.existsByUsername(dto.getUsername())){
            return Optional.empty();
        }
        UserModel user = new UserModel(dto);
        return Optional.of(userRepository.save(user));
    }
    public List<UserModel> getUsers(){
        List users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }
}
