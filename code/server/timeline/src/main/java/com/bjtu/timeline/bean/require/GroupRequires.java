package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class GroupRequires {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MakeRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DelRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int id;
        @NonNull String op;
        @NonNull int opuid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int id;
        String name;
    }

}
