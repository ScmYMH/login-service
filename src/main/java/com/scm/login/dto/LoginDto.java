package com.scm.login.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String token;
    private String userNm;
    private String userId;
    private String loginId;
    private String employeeNumber;
}
