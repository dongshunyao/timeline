package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.UserRequires;
import com.bjtu.timeline.bean.response.UserResponses;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public UserResponses.RegResponse reg(UserRequires.RegRequire req) {
        return userService.register(req.getNickname(), req.getPhone(), req.getCode(), req.getPassword());
    }

    @RequestMapping("/login")
    public UserResponses.LoginResponse login(UserRequires.LoginRequire req) {
        if ("phone".equals(req.getType())){
            return userService.loginWithPhone(req.getUrn(), req.getPw());
        }

        return new UserResponses.LoginResponse(-1, -1, "");
    }

}
