package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.TaskRequires.*;
import com.bjtu.timeline.bean.response.TaskResponses.*;
import com.bjtu.timeline.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/add")
    public AddResponse add(AddRequire req) {
        if (!taskService.checkUser(req)) {
            return new AddResponse(STATE_COMMON_FAIL);
        }
        return taskService.addTask(req);
    }

    @RequestMapping("/del")
    public DelResponse add(DelRequire req) {
        if (!taskService.checkUser(req)) {
            return new DelResponse(STATE_COMMON_FAIL);
        }
        return taskService.deleteTask(req.getTid());
    }

    @RequestMapping("/upd")
    public UpdResponse add(UpdRequire req) {
        if (!taskService.checkUser(req)) {
            return new UpdResponse(STATE_COMMON_FAIL);
        }
        return taskService.updateTask(req);
    }

    @RequestMapping("/view")
    public ViewResponse add(ViewRequire req) {
        if (!taskService.checkUser(req)) {
            return new ViewResponse(STATE_COMMON_FAIL, -1, "", -1, -1, "",
                    -1, -1);
        }
        return taskService.viewTask(req.getTid());
    }
}
