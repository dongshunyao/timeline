package com.bjtu.timeline.service;

import com.bjtu.common.Response;
import com.bjtu.common.StringUtil;
import com.bjtu.timeline.bean.User;
import com.bjtu.timeline.mapper.UserMapper;
import com.bjtu.timeline.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userDao;

    public Response register(String nickname, String phone, String code) {
        /*
        // 暂用手机号当uid
        User existUser = userDao.findUserByUid(generateUid(phone));
        if (existUser != null) {
            // 如果用户已存在
            return new UserResponse.register(-1, -1, "");

        } else {
            User user = new User();
            user.setUid(generateUid(phone));
            user.setNickname(nickname);
            user.setPassword("");
            user.setVIP(false);
            user.setRegtime(System.currentTimeMillis());
            userDao.register(user);
            // TODO: 是不是该多加点request信息，在这儿直接注册所有用户信息 --- userDao.register(user)
            // 或者进入SetPassword页面;
            return new UserResponse.register(0, user.getUid(), generateNewToken(user.getUid()));
        }
        */
        return new UserResponse.register(-1, -1, "");
    }

    public String generateNewToken(int uid) {
        String token = StringUtil.getRandString();
        // TODO: 优化
        return token;
    }

    public int generateUid(String phone) {
        // TODO: 优化
        return Integer.valueOf(phone);
    }
}
