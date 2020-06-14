package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class TaskRequires {
    public static interface Authentication {
        int getUid();
        String getToken();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskAddRequire implements Authentication{
        @NonNull int uid;
        @NonNull String token;
        @NonNull String title;
        @NonNull long begin;
        @NonNull long end;
        @NonNull String detail;
        @NonNull String repeat;
        @NonNull int groupid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskDelRequire implements Authentication{
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskUpdRequire implements Authentication{
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
        @NonNull String detail;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskViewRequire implements Authentication{
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskListRequire implements Authentication{
        @NonNull int uid;
        @NonNull String token;
    }
}
