package com.bjtu.timeline.bean.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBtask {
    int tid;
    int uid;
    int gid;
    String title;
    long begin;
    long end;
    String detail;
    int type;
}
