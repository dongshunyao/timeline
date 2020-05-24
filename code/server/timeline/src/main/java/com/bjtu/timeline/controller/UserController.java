package com.bjtu.timeline.controller;

import com.bjtu.common.Response;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public Response register(
            @RequestParam(value = "nickname", defaultValue = "") String nickname,
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "code", defaultValue = "") String code
    ) {
        return userService.register(nickname, phone, code);
    }
}
