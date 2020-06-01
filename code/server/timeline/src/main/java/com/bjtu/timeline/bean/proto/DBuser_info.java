package com.bjtu.timeline.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBuser_info {
    int uid;
    String nickname;
    long reftime;
    int isVIP;
}
