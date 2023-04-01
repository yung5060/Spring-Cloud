package com.kbank.userservice.service;

import com.kbank.userservice.dto.UserDto;

public interface UserService {
    
    UserDto createUser(UserDto userDto);
}
