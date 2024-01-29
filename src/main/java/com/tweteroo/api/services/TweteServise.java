package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweterooModel;
import com.tweteroo.api.repositories.TweteRepository;

@Service
public class TweteServise {
    final TweteRepository tweteRepository;
    TweteServise(TweteRepository tweteRepository){
        this.tweteRepository = tweteRepository;
    }
    public List<TweterooModel> findAll() {
        return tweteRepository.findAll();
    }

    public Optional<TweterooModel> save(TweteDTO dto){
        TweterooModel twete = new TweterooModel(dto);
        return Optional.of(tweteRepository.save(twete));
    }
}