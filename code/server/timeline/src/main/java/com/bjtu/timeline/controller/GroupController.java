package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.GroupRequires.*;
import com.bjtu.timeline.bean.response.GroupResponses.*;
import com.bjtu.timeline.service.GroupService;

import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ListResponse list(ListRequire req){
        if (!userService.checkUser(req)) {
            return new ListResponse(STATE_COMMON_FAIL,null,null);
        }
        return groupService.getGroupList(req.getUid());
    }



}
