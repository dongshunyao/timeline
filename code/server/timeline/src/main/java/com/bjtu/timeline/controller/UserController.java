package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.UserRequires;
import com.bjtu.timeline.bean.require.UserRequires.*;
import com.bjtu.timeline.bean.response.UserResponses;
import com.bjtu.timeline.bean.response.UserResponses.*;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonRespenses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonRespenses.STATE_COMMON_OK;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public LoginResponse login(LoginRequire req) {
        if ("phone".equals(req.getType())) {
            return userService.loginWithPhone(req.getUrn(), req.getPw());
        }

        return new LoginResponse(STATE_COMMON_FAIL, -1, "");
    }

    @RequestMapping("/logout")
    public LogoutResponse login(LogoutRequire req) {
        if (!userService.checkUser(req)) {
            return new LogoutResponse(STATE_COMMON_FAIL);
        }

        userService.logoutWithUid(req.getUid());
        return new LogoutResponse(STATE_COMMON_OK);
    }

    @RequestMapping("/reg")
    public RegResponse reg(RegRequire req) {
        return userService.register(req.getNickname(), req.getPhone(), req.getCode(), req.getPassword());
    }

    @RequestMapping("/phone")
    public PhoneResponse phone(PhoneRequire req) {
        //TODO: fill
        return new PhoneResponse(STATE_COMMON_FAIL);
    }

    @RequestMapping("/info")
    public InfoResponse info(InfoRequire req) {
        if (!userService.checkUser(req)) {
            return new InfoResponse(STATE_COMMON_FAIL, "", -1, -1);
        }
        return userService.getUserInfo(req.getUid());
    }

    @RequestMapping("/infoupd")
    public InfoupdResponse infoupd(InfoupdRequire req) {
        if (!userService.checkUser(req)) {
            return new InfoupdResponse(STATE_COMMON_FAIL);
        }
        // TODO: 其他信息
        return userService.updateUserInfo(req.getUid(), req.getNickname());
    }
}
