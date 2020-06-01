package com.bjtu.timeline.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBuser_reg {
    int uid;
    String qqid;
    String wechatid;
    String phone;
    String pwd;
}
