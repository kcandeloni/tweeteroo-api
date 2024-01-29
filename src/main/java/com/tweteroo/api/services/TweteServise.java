package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.repositories.TweteRepository;

@Service
public class TweteServise {
    final TweteRepository tweteRepository;
    TweteServise(TweteRepository tweteRepository){
        this.tweteRepository = tweteRepository;
    }
    public List<TweteModel> findAll() {
        return tweteRepository.findAll();
    }

    public Optional<TweteModel> save(TweteDTO dto){
        TweteModel twete = new TweteModel(dto);
        return Optional.of(tweteRepository.save(twete));
    }
}