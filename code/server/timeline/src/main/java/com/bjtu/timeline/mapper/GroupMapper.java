package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.proto.DBgroup_info;
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


    default int makeGroup(int uid, String name) {
        DBgroup_info rtv = new DBgroup_info(-1, uid, name);
        makeGroup(rtv);
        return rtv.getGid();
    }

    @Insert("insert into group_info(muid, gname) " +
            "values (#{body.muid},#{body.gname})")
    @Options(useGeneratedKeys = true, keyProperty = "body.gid")
    void makeGroup(@Param("body") DBgroup_info i);

    @Insert("insert into group_member " +
            "VALUES (#{gid},#{uid})")
    void addIntoGroup(int gid, int uid);

}
