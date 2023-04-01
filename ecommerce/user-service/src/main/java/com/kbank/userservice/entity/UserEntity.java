package com.kbank.userservice.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Long id;
    private String email;
    private String name;
    private String userId;
    private String encryptedPwd;
}
