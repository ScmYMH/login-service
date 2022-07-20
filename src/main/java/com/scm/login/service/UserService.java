package com.scm.login.service;

import com.scm.login.dto.LoginDto;
import com.scm.login.dto.RequestLoginDto;
import com.scm.login.entity.UserEntity;
import com.scm.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    public LoginDto getLogin(RequestLoginDto requestLoginDto){
        UserEntity loginUser = userRepository.findUserByLoginIdAndLoginPw(requestLoginDto.getLoginId(), requestLoginDto.getLoginPw());

        return LoginDto.builder()
                .userNm(loginUser.getUserNm())
                .token("asdkajsldk")
                .build();
    }
}