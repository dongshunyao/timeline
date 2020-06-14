package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class UserRequires {

    public static interface Authentication {
        int getUid();
        String getToken();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequire {
        @NonNull String type;
        @NonNull String urn;
        @NonNull String pw;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogoutRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegRequire {
        @NonNull String nickname;
        @NonNull String phone;
        @NonNull String code;
        @NonNull String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneRequire {
        @NonNull String phone;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoupdRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull String nickname;
    }

}
