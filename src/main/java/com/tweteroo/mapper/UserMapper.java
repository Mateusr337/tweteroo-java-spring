package com.tweteroo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.tweteroo.domain.dto.UserDto;
import com.tweteroo.domain.model.User;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    User toModel (UserDto userDto);
    UserDto toDto (User user);
    
}
