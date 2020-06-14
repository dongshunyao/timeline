package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.require.TaskRequires;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TaskMapper {

    @Select("select count(*) != 0 from user_login " +
            "where uid = #{uid} and token = #{token}")
    boolean checkToken(int uid, String token);

    @Insert("insert into task (uid,gid,title,begin,end,detail,type) " +
            "values (#{uid},#{groupid},#{title},#{begin},#{end},#{detail},#{type})")
    void addTaskInfo(TaskRequires.AddRequire addRequire);
}
