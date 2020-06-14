package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.UserRequires.*;
import com.bjtu.timeline.bean.response.UserResponses.*;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public LoginResponse login(LoginRequire req) {
        if ("phone".equals(req.getType())){
            return userService.loginWithPhone(req.getUrn(), req.getPw());
        }

        return new LoginResponse(-1, -1, "");
    }

    @RequestMapping("/logout")
    public LogoutResponse login(LogoutRequire req) {
        if (!userService.checkUser(req)){
            return new LogoutResponse(-1);
        }

        userService.logoutWithUid(req.getUid());
        return new LogoutResponse(0);
    }

    @RequestMapping("/reg")
    public RegResponse reg(RegRequire req) {
        return userService.register(req.getNickname(), req.getPhone(), req.getCode(), req.getPassword());
    }

    @RequestMapping("/phone")
    public PhoneResponse phone(PhoneRequire req) {
        //TODO: fill
        return new PhoneResponse(-1);
    }

}
