package com.kbank.userservice.vo;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
