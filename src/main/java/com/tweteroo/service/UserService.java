package com.tweteroo.service;

import com.tweteroo.domain.dto.UserDto;
import com.tweteroo.domain.model.User;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface UserService {

    void createUser (UserDto userDto);

    User  findUserByUsername (String name) throws NotFoundException;



}
