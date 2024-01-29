package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweteDTO;
import com.tweteroo.api.models.TweterooModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/tweteroo")
public class TweterooController {
    private List<TweterooModel> twetes = new ArrayList<>();
    @GetMapping
    public List<TweterooModel> getTwetes() {
        return twetes;
    }
    @PostMapping
    public void setTwetes(TweteDTO twete) {
        this.twetes.add(new TweterooModel(twete));
    }
}
