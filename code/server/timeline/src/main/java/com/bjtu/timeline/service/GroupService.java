package com.bjtu.timeline.service;

import com.bjtu.timeline.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class GroupService {

    @Autowired
    private GroupMapper groupDao;


}
