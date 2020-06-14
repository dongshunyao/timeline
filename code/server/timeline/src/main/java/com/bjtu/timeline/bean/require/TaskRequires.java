package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import com.bjtu.timeline.bean.require.UserRequires.Authentication;

public class TaskRequires {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ViewRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
        String title;
        long begin;
        long end;
        String detail;
        String repeat;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        String title;
        long begin;
        long end;
        String detail;
        int type;
        int groupid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DelRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
    }

}
