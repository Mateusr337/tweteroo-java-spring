package com.tweteroo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class UserDto { 

    @NotBlank (message = "Username must not be blank")
    private String username;

    @NotBlank (message = "Avatar must not be blank")
    @URL (message = "Avatar must be a URL image")
    private String avatar;
}
