package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.response.RcdResponses.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RcdMapper {

    @Select("SELECT * from record_body " +
            "where uid = #{uid}")
    List<ListResponse.listElm> getListByUid(int uid);

}
