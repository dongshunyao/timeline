package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.require.GroupRequires.*;
import com.bjtu.timeline.bean.response.GroupResponses.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupMapper {

    @Select("select gid as id, gname as name from group_info " +
            "where muid = #{uid}")
    List<ListResponse.elm> selectListManage(int uid);

    @Select("select gid as id, gname as name from group_info " +
            "where gid in (" +
                "select gid from group_member where uid = #{uid}" +
            ")")
    List<ListResponse.elm> selectListIn(int uid);

}
