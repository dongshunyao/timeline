package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserResponses {

    @Data
    @AllArgsConstructor
    public static class LoginResponse extends BaseRespense {
        private int state;
        private int uid;
        private String token;
    }

    @Data
    @AllArgsConstructor
    public static class RegResponse extends BaseRespense {
        private int state;
        private int uid;
        private String token;
    }

}
