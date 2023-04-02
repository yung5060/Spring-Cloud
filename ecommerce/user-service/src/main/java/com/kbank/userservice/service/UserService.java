package com.kbank.userservice.service;

import com.kbank.userservice.dto.UserDto;
import com.kbank.userservice.entity.UserEntity;

public interface UserService {
    
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
