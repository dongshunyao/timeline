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

    public Response register(String nickname, String phone, String code, String password) {
        /*
        // 暂用手机号当uid
        User existUser = userDao.findUserByUid(generateUid(phone));
        if (existUser != null) {
            // 如果用户已存在
            return new UserResponse.register(-1, -1, "User already existed!");

        } else {
            User user = new User();
            user.setUid(generateUid(phone));
            user.setPhone(Integer.valueOf(phone));
            user.setNickname(nickname);
            user.setPassword(password);
            user.setVIP(false);
            user.setRegtime(System.currentTimeMillis());
            userDao.register(user);
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

    public Response login(String urn, String password) {
        /*
        User existUser = userDao.findUserByPhone(Integer.valueOf(urn));
        if (existUser != null) {
            // 如果用户不存在
            return new UserResponse.register(-1, -1, "No such user!");
        } else {
            if (password.equals(existUser.getPassword()))
                return new UserResponse.register(0, existUser.getUid(),
                        generateNewToken(existUser.getUid()));
            else return new UserResponse.register(-1, -1, "Wrong password!");
        }
        */

        return new UserResponse.register(-1, -1, "No such user!");
    }
}
