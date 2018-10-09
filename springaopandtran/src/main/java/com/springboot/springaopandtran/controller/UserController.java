package com.springboot.springaopandtran.controller;

import com.springboot.springaopandtran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/save1")
    public void save1(){
        userService.save1();
    }


    @RequestMapping("/save2")
    public void save2(){
        userService.save2();
    }










}
