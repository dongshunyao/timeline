package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graalvm.compiler.lir.phases.EconomyAllocationStage;

public class UserResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        int state;
        int uid;
        String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogoutResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegResponse  {
        int state;
        int uid;
        String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoResponse {
        int state;
        String nickname;
        int isVIP;
        long regtime;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoupdResponse {
        int state;
    }

}
