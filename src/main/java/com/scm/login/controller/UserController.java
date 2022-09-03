package com.scm.login.controller;

import com.scm.login.config.SecurityService;
import com.scm.login.dto.LoginDto;
import com.scm.login.dto.RequestLoginDto;
import com.scm.login.entity.UserEntity;
import com.scm.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<UserEntity> getUserAll(){
        return userService.getUser();
    }

    @PostMapping("/login")
    public LoginDto login(@RequestBody RequestLoginDto requestLoginDto){
        return userService.getLogin(requestLoginDto);
    }

    @GetMapping("/check")
    public Boolean check(){
        return true;
    }
}