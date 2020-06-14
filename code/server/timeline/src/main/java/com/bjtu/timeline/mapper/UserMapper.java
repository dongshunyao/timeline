package com.bjtu.timeline.mapper;

import com.bjtu.timeline.bean.middle.User;
import com.bjtu.timeline.bean.proto.DBuser_info;
import com.bjtu.timeline.bean.proto.DBuser_login;
import com.bjtu.timeline.bean.proto.DBuser_reg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    /*
    @Select("select * from user where uid=#{uid}")
    User findUserByUid(int uid);

    @Select("select * from user where phone=#{phone}")
    User findUserByPhone(int phone);

    @Insert("insert into user values(#{uid},#{phone},#{nickname},#{password},#{isVIP},#{regtime})")
    void register(User user);
    */

    @Select("select * from user_reg " +
            "where phone=#{phone} and pwd=#{pwd}")
    DBuser_reg getUserByPhoneAndPassword(String phone, String pwd);

    @Insert("insert into user_login (uid,token) " +
            "values (#{uid},#{token}) " +
            "ON DUPLICATE KEY UPDATE token = #{token}")
    void updateToken(int uid, String token);

    @Select("select * from user_login where uid=#{uid} and token=#{token}")
    DBuser_login getOnlineUserByUidAndToken(int uid, String token);
    @Delete("delete from user_login where uid=#{uid} and token=#{token}")
    void deleteOnlineUserByUidAndToken(int uid, String token);

    @Select("select * from user_info where uid=#{uid}")
    DBuser_info getUserInfoByUid(int uid);
}
