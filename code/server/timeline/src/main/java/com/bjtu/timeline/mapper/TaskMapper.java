package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.proto.DBtask;
import com.bjtu.timeline.bean.require.TaskRequires;
import com.bjtu.timeline.bean.response.TaskResponses;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TaskMapper {

    @Insert("insert into task (uid,gid,title,begin,end,detail,type) " +
            "values (#{uid},#{groupid},#{title},#{begin},#{end},#{detail},#{type})")
    void addTaskInfo(TaskRequires.AddRequire addRequire);

    @Delete("delete from task where tid=#{tid}")
    boolean deleteTaskByTid(int tid);

    @Update("update task set detail=#{detail} where tid=#{tid}")
    void updateTaskByTid(TaskRequires.UpdRequire updRequire);

    @Select("select * from task where tid=#{tid}")
    DBtask getTaskByTid(int tid);

    @Select("select * from task where uid=#{uid}")
    List<TaskResponses.ListResponse.listElm> getTaskListByUid(int uid);
    // List<DBtask> getTaskListByUid(int uid);
}
