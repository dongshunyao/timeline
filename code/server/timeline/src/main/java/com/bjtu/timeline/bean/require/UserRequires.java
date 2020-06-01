package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserRequires {

    public interface Authentication {
        int getUid();
        String getToken();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequire {
        String type;
        String urn;
        String pw;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogoutRequire implements Authentication {
        int uid;
        String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegRequire {
        String nickname;
        String phone;
        String code;
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneRequire {
        String phone;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoRequire implements Authentication {
        int uid;
        String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoupdRequire implements Authentication {
        int uid;
        String token;
        String nickname;
    }

}
