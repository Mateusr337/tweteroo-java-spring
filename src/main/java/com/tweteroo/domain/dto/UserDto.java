package com.tweteroo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto { 

    @NotBlank (message = "Username must not be blank")
    private String username;

    @NotBlank (message = "Avatar must not be blank")
    private String avatar;
}
