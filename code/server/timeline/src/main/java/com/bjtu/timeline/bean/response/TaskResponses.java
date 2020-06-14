package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class TaskResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListResponse {
        int state;
        List<listElm> list;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class listElm {
            int tid;
            String title;
            long begin;
            long end;
            String detail;
            String repeat;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ViewResponse {
        int state;
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
    public static class UpdResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResponse {
        int state;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DelResponse {
        int state;
    }

}
