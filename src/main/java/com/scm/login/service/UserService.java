package com.scm.login.service;

import com.scm.login.config.SecurityService;
import com.scm.login.dto.LoginDto;
import com.scm.login.dto.RequestLoginDto;
import com.scm.login.entity.UserEntity;
import com.scm.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SecurityService securityService;

    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    public LoginDto getLogin(RequestLoginDto requestLoginDto){
        UserEntity loginUser = userRepository.findUserByLoginIdAndLoginPw(requestLoginDto.getLoginId(), requestLoginDto.getLoginPw());
        String token = securityService.createToken(loginUser.getUserId().toString());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization","Bearer "+token);
        Map<String,Object> map=new HashMap<>();
        Map<String, Object> headers = new HashMap<>();
        map.put("token",token);
        map.put("id",loginUser.getUserId());
        map.put("userNm", loginUser.getUserNm());
        map.put("userId", loginUser.getUserId());
        map.put("expNo", loginUser.getEmployeeNumber());
        map.put("loginId", loginUser.getLoginId());
        log.info(String.valueOf(map));
        return LoginDto.builder()
                .userNm(loginUser.getUserNm())
                .userId(loginUser.getUserId())
                .loginId(loginUser.getLoginId())
                .employeeNumber(loginUser.getEmployeeNumber())
                .token(token)
                .build();
    }
}