package com.bjtu.timeline.response;

import com.bjtu.common.Response;
import lombok.Data;

public class UserResponse {
    @Data
    public static class register implements Response {
        private int state;
        private int uid;
        private String token;

        public register() {
        }

        public register(int state, int uid, String token) {
            this.state = state;
            this.uid = uid;
            this.token = token;
        }
    }
}
