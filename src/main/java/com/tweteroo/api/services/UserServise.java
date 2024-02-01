package com.tweteroo.api.services;

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
        UserModel user = new UserModel(dto);
        return Optional.of(userRepository.save(user));
    }
}
