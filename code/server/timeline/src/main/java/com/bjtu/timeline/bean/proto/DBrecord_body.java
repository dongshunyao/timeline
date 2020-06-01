package com.bjtu.timeline.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBrecord_body {
    int rid;
    int uid;
    String title;
    long time;
    String detail;
}
