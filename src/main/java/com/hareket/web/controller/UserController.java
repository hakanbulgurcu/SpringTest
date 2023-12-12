package com.hareket.web.controller;

import com.hareket.web.model.User;
import com.hareket.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller()
public class UserController {

    @Autowired
    UserService service;

    User user = new User();

    @RequestMapping("/user")
    @ResponseBody
    public String welcome() {
        return "User Check Service";
    }

    public User getUser() {
        return user;
    }
}
