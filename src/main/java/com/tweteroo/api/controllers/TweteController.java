package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.services.TweteServise;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tweteroo")
public class TweteController {
    final TweteServise tweteService;

    TweteController(TweteServise tweteServise){
        this.tweteService = tweteServise;
    }

    @GetMapping
    public ResponseEntity<List<TweteModel>> getTwetes() {
        List<TweteModel> twetes = tweteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(twetes);
    }
    @PostMapping
    public ResponseEntity<Optional<TweteModel>> setTwete(@RequestBody @Valid TweteDTO body) {
        Optional<TweteModel> twete = tweteService.save(body);
        if (!twete.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(twete);
    }
}
