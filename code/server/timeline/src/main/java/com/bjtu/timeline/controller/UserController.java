package com.bjtu.timeline.controller;

import com.bjtu.common.Response;
import com.bjtu.timeline.response.UserResponse;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public Response register(
            @RequestParam(value = "nickname", defaultValue = "") String nickname,
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "code", defaultValue = "") String code,
            @RequestParam(value = "password", defaultValue = "") String password
    ) {
        return userService.register(nickname, phone, code, password);
    }

    @RequestMapping("/login")
    public Response register(
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "urn", defaultValue = "") String urn,
            @RequestParam(value = "pwd", defaultValue = "") String pwd
    ) {
        if (type.equals("phone") || true)
            return userService.login(urn, pwd);
        else return new UserResponse.register(-1, -1, "");
    }
}
