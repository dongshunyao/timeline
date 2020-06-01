package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.middle.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user where uid=#{uid}")
    User findUserByUid(int uid);

    @Select("select * from user where phone=#{phone}")
    User findUserByPhone(int phone);

    @Insert("insert into user values(#{uid},#{phone},#{nickname},#{password},#{isVIP},#{regtime})")
    void register(User user);
}
