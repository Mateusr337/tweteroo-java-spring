package com.tweteroo.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
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

    public void createUser (UserDto userDto) throws NotFoundException {
        findUserByUsername(userDto.getUsername());
        log.info("Trying create user {} ...", userDto.getUsername());
        User user = userRepository.save(userMapper.toModel(userDto));
        log.info("Created user with id {}", user.getId());
    }

    public User findUserByUsername (String username) throws NotFoundException {
        log.info("Trying find username {} ...", username);
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isPresent()) {
            log.info("Found username {}", user.get().getUsername());
            return user.get();
        }
        log.info("Found username {}", username);
        throw new NotFoundException();
    }

}
