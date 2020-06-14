package com.bjtu.timeline.service;

import com.bjtu.timeline.bean.require.TaskRequires;
import com.bjtu.timeline.bean.require.TaskRequires.*;
import com.bjtu.timeline.bean.require.UserRequires;
import com.bjtu.timeline.bean.response.TaskResponses.*;
import com.bjtu.timeline.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskDao;

    public boolean checkUser(UserRequires.Authentication taskRequire) {
        if ("".equals(taskRequire.getToken())) return false;
        return taskDao.checkToken(taskRequire.getUid(), taskRequire.getToken());
    }

    public AddResponse addTask(AddRequire req){
        taskDao.addTaskInfo(req);
        return new AddResponse(STATE_COMMON_OK);
    }
}
