package com.kbank.userservice.dto;

import java.util.Date;
import java.util.List;

import com.kbank.userservice.vo.ResponseOrder;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String pwd;
    private String name;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
