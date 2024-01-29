package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweteDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweterooModel {
    private String text;
    private Long userId;

    public TweterooModel(TweteDTO dto){
        this.text = dto.getText();
        this.userId = dto.getUserId();
    }
}
