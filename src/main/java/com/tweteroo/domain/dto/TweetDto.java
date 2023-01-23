package com.tweteroo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TweetDto {

  @NotBlank (message = "Username must not be blank")
  private String username;

  @NotBlank (message = "Tweet must not be blank")
  private String text;
}
