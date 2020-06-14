package com.bjtu.timeline.service;

import com.bjtu.common.StringUtil;
import com.bjtu.timeline.bean.proto.DBuser_reg;
import com.bjtu.timeline.bean.response.UserResponses.*;
import com.bjtu.timeline.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bjtu.common.StringUtil.*;
import static com.bjtu.timeline.bean.response.CommonRespenses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonRespenses.STATE_COMMON_OK;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public RegResponse register(String nickname, String phone, String code, String password) {
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
        return new RegResponse(-1, -1, "");
    }

    public String generateNewToken() {
        return getRandString();
    }

    public LoginResponse loginWithPhone(String urn, String password) {

        DBuser_reg selectedUser = userDao.getUserByPhoneAndPassword(urn,password);

        //无用户或密码错误
        //理论上这俩必须表现同一返回值（原因可以百度），实际上这样也血妈好写
        if (selectedUser == null) {
            return new LoginResponse(STATE_COMMON_FAIL,-1,"");
        } else {
            String token = generateNewToken();
            userDao.updateToken(selectedUser.getUid(),token);
            return new LoginResponse(STATE_COMMON_OK,selectedUser.getUid(),token);
        }

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

        return new UserResponses.LoginResponse(-1, -1, "No such user!");
        */

    }
}
