package com.bjtu.timeline.bean.middle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int uid;
    private int phone;
    private String nickname;
    private String password;
    private boolean isVIP;
    private long regtime;
}
