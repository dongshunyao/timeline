package com.bjtu.timeline.bean;

import lombok.Data;

@Data
public class User {
    private int uid;

    private String nickname;

    private String password;

    private boolean isVIP;

    private long regtime;
}
