package com.bjtu.timeline.bean.require;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class SearchRequires {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchRequire implements UserRequires.Authentication {
        @NonNull int uid;
        @NonNull String token;
        int type;
        String word;
    }

}
