package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserRequires {

    @Data
    @AllArgsConstructor
    public static class LoginRequire extends BaseRequire {
        String type;
        String urn;
        String pw;
    }

    @Data
    @AllArgsConstructor
    public static class RegRequire extends BaseRequire {
        String nickname;
        String phone;
        String code;
        String password;
    }

}
