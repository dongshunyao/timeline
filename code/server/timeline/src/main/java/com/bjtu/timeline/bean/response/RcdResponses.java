package com.bjtu.timeline.bean.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class RcdResponses {

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
            int rid;
            String title;
            long time;
            String detail;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ViewResponse {
        int state;
        int rid;
        String title;
        long time;
        String detail;
        List<String> picture;
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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PicUploadResponse {
        int state;
    }

}
