package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "twetes")
public class TweteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 280, nullable = false)
    private String text;
    @Column(nullable = false)
    private Long userId;

    public TweteModel(TweteDTO dto){
        this.text = dto.getText();
        this.userId = dto.getUserId();
    }
}
