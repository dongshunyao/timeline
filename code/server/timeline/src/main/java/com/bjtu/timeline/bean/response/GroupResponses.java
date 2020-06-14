package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class GroupResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListResponse {
        int state;
        List<elm> listmanage;
        List<elm> listin;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class elm{
            int id;
            String name;
        }

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MakeResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DelResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoResponse {
        int state;
        String name;
        List<String> member;
        List<elmTask> task;
        List<elmUser> wantjoin;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class elmTask {
            int tid;
            String title;
            long begin;
            long end;
            String detail;
            String repeat;
            int group;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class elmUser{
            int id;
            String name;
        }

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdResponse {
        int state;
    }

}
