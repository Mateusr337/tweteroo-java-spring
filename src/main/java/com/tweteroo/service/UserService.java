package com.tweteroo.service;

import com.tweteroo.domain.dto.UserDto;
import com.tweteroo.domain.model.User;

public interface UserService {

    User createUser (UserDto userDto);

}
