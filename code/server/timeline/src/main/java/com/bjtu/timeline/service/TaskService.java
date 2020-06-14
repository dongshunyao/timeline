package com.bjtu.timeline.service;

import com.bjtu.timeline.bean.proto.DBtask;
import com.bjtu.timeline.bean.require.TaskRequires;
import com.bjtu.timeline.bean.require.TaskRequires.*;
import com.bjtu.timeline.bean.require.UserRequires;
import com.bjtu.timeline.bean.response.TaskResponses.*;
import com.bjtu.timeline.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskDao;

    // 判断是否在线
    public boolean checkUser(UserRequires.Authentication taskRequire) {
        if ("".equals(taskRequire.getToken())) return false;
        return taskDao.checkToken(taskRequire.getUid(), taskRequire.getToken());
    }

    // 添加task
    public AddResponse addTask(AddRequire req) {
        taskDao.addTaskInfo(req);
        return new AddResponse(STATE_COMMON_OK);
    }

    // 删除task
    public DelResponse deleteTask(int tid) {
        boolean check = taskDao.deleteTaskByTid(tid);
        if (!check)
            return new DelResponse(STATE_COMMON_FAIL);
        return new DelResponse(STATE_COMMON_OK);
    }

    // 修改task内容
    public UpdResponse updateTask(UpdRequire updRequire) {
        taskDao.updateTaskByTid(updRequire);
        return new UpdResponse(STATE_COMMON_OK);
    }

    // 查看单个task
    public ViewResponse viewTask(int tid) {
        DBtask selectedTask = taskDao.getTaskByTid(tid);
        // 判断是否为小组task
        int isGroup = selectedTask.getGid() > 0 ? 1 : 0;
        return new ViewResponse(STATE_COMMON_OK, selectedTask.getTid(), selectedTask.getTitle(),
                selectedTask.getBegin(), selectedTask.getEnd(), selectedTask.getDetail(),
                selectedTask.getType(), isGroup);
    }

    // 查看task列表
    public ListResponse viewTaskList(int uid) {
        // List<DBtask> taskList = taskDao.getTaskListByUid(uid);
        List<ListResponse.listElm> taskList = taskDao.getTaskListByUid(uid);
        return new ListResponse(STATE_COMMON_OK, taskList);
    }
}
