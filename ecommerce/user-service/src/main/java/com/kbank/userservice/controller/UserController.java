package com.kbank.userservice.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kbank.userservice.dto.UserDto;
import com.kbank.userservice.service.UserService;
import com.kbank.userservice.vo.Greeting;
import com.kbank.userservice.vo.RequestUser;
import com.kbank.userservice.vo.ResponseUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public String check() {
        return String.format("Current PORT = %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        // return String.format(env.getProperty("greeting.message"));
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody RequestUser user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto = userService.createUser(userDto);

        ResponseUser responseUser = modelMapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
