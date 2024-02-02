package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweteRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweteServise {
    final TweteRepository tweteRepository;
    final UserRepository userRepository;
    TweteServise(TweteRepository tweteRepository, UserRepository userRepository){
        this.tweteRepository = tweteRepository;
        this.userRepository = userRepository;
    }
    public List<TweteModel> findAll() {
        return tweteRepository.findAll();
    }

    public Optional<TweteModel> save(TweteDTO dto){
        Optional<UserModel> user = userRepository.findById(dto.getUserId());
        if(!user.isPresent()){
            return Optional.empty();
        }
        TweteModel twete = new TweteModel(dto, user.get());
        return Optional.of(tweteRepository.save(twete));
    }
}