package com.bjtu.timeline.service;

import com.bjtu.timeline.bean.proto.DBuser_reg;
import com.bjtu.timeline.bean.require.UserRequires;
import com.bjtu.timeline.bean.response.UserResponses.*;
import com.bjtu.timeline.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bjtu.common.StringUtil.*;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public RegResponse register(String nickname, String phone, String code, String password) {

        //TODO: code check

        if(userDao.getUserByPhone(phone) != null){
            return new RegResponse(STATE_COMMON_FAIL, -1, "");
        }

        userDao.regByPhone(phone,password);
        LoginResponse loginInfo = loginWithPhone(phone, password);

        //TODO: modify nickName, record regTime
        //TODO: fill when finish modify server
        //userDao.modifyInfo(...);

        return new RegResponse(STATE_COMMON_OK, loginInfo.getUid(), loginInfo.getToken());
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

    }

    public boolean checkUser(UserRequires.Authentication userInfo){
        if("".equals(userInfo.getToken()))return false;
        return userDao.checkToken(userInfo.getUid(),userInfo.getToken());
    }

    public void logoutWithUid(int uid){
        userDao.updateToken(uid,"");
    }

}
