package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.proto.DBrecord_body;
import com.bjtu.timeline.bean.response.RcdResponses.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

}
