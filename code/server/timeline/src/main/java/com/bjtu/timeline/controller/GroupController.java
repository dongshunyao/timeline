package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.TaskRequires.*;
import com.bjtu.timeline.bean.response.TaskResponses.*;
import com.bjtu.timeline.service.GroupService;
import com.bjtu.timeline.service.TaskService;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    private UserService userService;

}
