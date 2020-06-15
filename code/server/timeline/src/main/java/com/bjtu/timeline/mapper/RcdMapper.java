package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.proto.DBrecord_body;
import com.bjtu.timeline.bean.response.RcdResponses.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RcdMapper {

    @Select("select * from record_body " +
            "where uid = #{uid}")
    List<ListResponse.listElm> getListByUid(int uid);

    @Select("select * from record_body " +
            "where rid = #{rid}")
    DBrecord_body getRcdByRid(int rid);

    @Select("select picid from record_pic " +
            "where rid = #{rid} " +
            "order by pos")
    List<String> rcdDaoPicListByRid(int rid);

    @Update("update record_body " +
            "set title = #{title} " +
            "where rid = #{rid}")
    void updateTitle(int rid, String title);

    @Update("update record_body " +
            "set time = #{time} " +
            "where rid = #{rid}")
    void updateTime(int rid, long time);

    @Update("update record_body " +
            "set detail = #{detail} " +
            "where rid = #{rid}")
    void updateDetail(int rid, String detail);

    @Delete("delete from record_pic " +
            "where rid = #{rid}")
    void cleanPictures(int rid);

    @Insert("insert into record_pic " +
            "values (#{rid},#{path},#{pos})")
    void addPicture(int rid, String path, int pos);

    default int addRecord(int uid,String title,long time,String detail) {
        DBrecord_body rtv = new DBrecord_body(-1, uid, title,time,detail);
        addRecord(rtv);
        return rtv.getRid();
    }

    @Insert("insert into record_body(uid, title, time, detail) " +
            "values (#{body.uid},#{body.title},#{body.time},#{body.detail})")
    @Options(useGeneratedKeys = true, keyProperty = "body.rid")
    void addRecord(@Param("body") DBrecord_body i);

}
