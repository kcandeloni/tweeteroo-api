package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String avatar;
}
