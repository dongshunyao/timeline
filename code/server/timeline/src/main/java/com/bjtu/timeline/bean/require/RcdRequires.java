package com.bjtu.timeline.bean.require;

import com.bjtu.timeline.bean.require.UserRequires.Authentication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RcdRequires {

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
        @NonNull int rid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int tid;
        String title;
        long time;
        String detail;
        List<String> picture;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        String title;
        long time;
        String detail;
        List<String> picture;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DelRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull int rid;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PicUploadRequire implements Authentication {
        @NonNull int uid;
        @NonNull String token;
        @NonNull MultipartFile pic;
    }

}
