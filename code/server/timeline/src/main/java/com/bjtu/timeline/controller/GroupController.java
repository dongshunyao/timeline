package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.GroupRequires.*;
import com.bjtu.timeline.bean.response.GroupResponses.*;
import com.bjtu.timeline.service.GroupService;

import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ListResponse list(ListRequire req) {
        if (!userService.checkUser(req)) {
            return new ListResponse(STATE_COMMON_FAIL, null, null);
        }
        return groupService.getGroupList(req.getUid());
    }

    @RequestMapping("/make")
    public MakeResponse make(MakeRequire req) {
        if (!userService.checkUser(req)) {
            return new MakeResponse(STATE_COMMON_FAIL);
        }
        return groupService.makeGroup(req.getUid(), req.getName());
    }

    @RequestMapping("/del")
    public DelResponse del(DelRequire req) {
        if (!userService.checkUser(req)) {
            return new DelResponse(STATE_COMMON_FAIL);
        }
        return groupService.deleteGroup(req.getUid(), req.getId());
    }

    @RequestMapping("/join")
    public JoinResponse join(JoinRequire req) {
        if (!userService.checkUser(req)) {
            return new JoinResponse(STATE_COMMON_FAIL);
        }
        return groupService.applyJoinGroup(req.getUid(), req.getId());
    }

    @RequestMapping("/manage")
    public ManageResponse manage(ManageRequire req) {
        if (!userService.checkUser(req)) {
            return new ManageResponse(STATE_COMMON_FAIL);
        }
        if("add".equals(req.getOp())){
            return groupService.agreeJoin(req.getUid(),req.getId(),req.getOpuid());
        }else if("del".equals(req.getOp())){
            return groupService.disagreeOrKick(req.getUid(),req.getId(),req.getOpuid());
        }else{
            return new ManageResponse(-2);// arg err
        }
    }

    @RequestMapping("/info")
    public InfoResponse info(InfoRequire req){
        if (!userService.checkUser(req)) {
            return new InfoResponse(STATE_COMMON_FAIL,"",null,null,null);
        }
        return groupService.getInfo(req.getUid(),req.getId());
    }

}
