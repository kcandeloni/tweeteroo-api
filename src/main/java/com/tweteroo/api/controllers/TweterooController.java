package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweterooModel;
import com.tweteroo.api.services.TweteServise;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/tweteroo")
public class TweterooController {
    final TweteServise tweteService;

    TweterooController(TweteServise tweteServise){
        this.tweteService = tweteServise;
    }

    @GetMapping
    public List<TweterooModel> getTwetes() {
        List<TweterooModel> twetes = tweteService.findAll();
        return twetes;
    }
    @PostMapping
    public void setTwete(TweteDTO twete) {
        
    }
}
