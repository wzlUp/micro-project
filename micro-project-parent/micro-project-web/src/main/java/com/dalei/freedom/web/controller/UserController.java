package com.dalei.freedom.web.controller;

import com.dalei.freedom.common.web.BaseController;
import com.dalei.freedom.commoninterface.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: micro-project
 * @description: 用户控制层
 * @author: weizl
 * @create: 2019-02-28 16:53
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        String phone = "13888888888";
        String result = new Gson().toJson(userService.findUserByPhone(phone));
        return "web to getUserInfo" + result;
    }

}
