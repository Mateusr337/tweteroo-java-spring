package com.tweteroo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.domain.dto.UserDto;
import com.tweteroo.domain.model.User;
import com.tweteroo.mapper.UserMapper;
import com.tweteroo.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public String createUser (@RequestBody @Valid UserDto userDto) {
        log.info("Received user {} ...", userDto.getUsername());
        userService.createUser(userDto);
        return "OK";
    }
    
}
