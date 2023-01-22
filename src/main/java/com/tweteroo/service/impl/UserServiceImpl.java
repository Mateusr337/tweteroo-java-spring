package com.tweteroo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.domain.dto.UserDto;
import com.tweteroo.domain.model.User;
import com.tweteroo.mapper.UserMapper;
import com.tweteroo.repository.UserRepository;
import com.tweteroo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void createUser (UserDto userDto) {
        log.info("Trying create user {} ...", userDto.getUsername());
        User user = userRepository.save(userMapper.toModel(userDto));
        log.info("Created user with id {}", user.getId());
    }
    
}
