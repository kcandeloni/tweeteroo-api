package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserModel user;
    public TweteModel(TweteDTO dto){
        this.text = dto.getText();
        this.user = new UserModel();
        this.user.setId(dto.getUserId());
    }
    public TweteModel(TweteDTO dto, UserModel user){
        this.text = dto.getText();
        this.user = user;
    }
}
