package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class SearchResponses {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchResponse {
        int state;
        List<elmTask> listtask;
        List<elmRcd> listrcd;

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
        public static class elmRcd {
            int rid;
            String title;
            long time;
            String detail;
            List<String> picture;
        }

    }

}
