package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweteModel;
import com.tweteroo.api.services.TweteServise;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/tweteroo")
public class TweteController {
    final TweteServise tweteService;

    TweteController(TweteServise tweteServise){
        this.tweteService = tweteServise;
    }

    @GetMapping
    public List<TweteModel> getTwetes() {
        List<TweteModel> twetes = tweteService.findAll();
        return twetes;
    }
    @PostMapping
    public void setTwete(TweteDTO twete) {
        
    }
}
