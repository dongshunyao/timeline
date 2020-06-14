package com.bjtu.timeline.service;

import com.bjtu.timeline.bean.proto.DBgroup_info;
import com.bjtu.timeline.bean.response.GroupResponses.*;
import com.bjtu.timeline.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class GroupService {

    @Autowired
    private GroupMapper groupDao;

    public ListResponse getGroupList(int uid) {
        List<ListResponse.elm> listManage = groupDao.selectListManage(uid);
        List<ListResponse.elm> listIn = groupDao.selectListIn(uid);
        return new ListResponse(STATE_COMMON_OK, listManage, listIn);
    }

    public MakeResponse makeGroup(int uid, String name) {
        int gid = groupDao.makeGroup(uid, name);
        groupDao.addIntoGroup(uid, gid);
        return new MakeResponse(STATE_COMMON_OK);
    }

    public DelResponse deleteGroup(int uid, int gid) {
        int effectCnt = groupDao.deleteGroup(uid, gid);
        if (effectCnt == 0) {
            return new DelResponse(-10);//没有这个属于你的这个组
        }
        groupDao.cleanMember(gid);
        groupDao.cleanApplication(gid);
        return new DelResponse(STATE_COMMON_OK);
    }

    public JoinResponse applyJoinGroup(int uid, int gid) {
        //exist?
        if (groupDao.checkGroup(gid) == 0) {
            return new JoinResponse(-10);//没有这个组
        }

        //already member?
        if (groupDao.checkMember(uid, gid) != 0) {
            return new JoinResponse(-11);//已经在这个组
        }

        //already apply? & do apply
        if (groupDao.doApply(uid, gid) == 0) {
            return new JoinResponse(-12);//已经申请
        }

        return new JoinResponse(STATE_COMMON_OK);
    }

    public ManageResponse agreeJoin(int managerUid, int gid, int targetUid) {
        //manager?
        if (groupDao.checkManager(managerUid, gid) == 0) {
            return new ManageResponse(-10);//不是管理员
        }

        //has apply?
        if (groupDao.removeApply(targetUid, gid) == 0) {
            return new ManageResponse(-11);//没有这个申请
        }

        groupDao.addIntoGroup(targetUid, gid);
        return new ManageResponse(STATE_COMMON_OK);
    }

    public ManageResponse disagreeOrKick(int managerUid, int gid, int targetUid) {
        //manager?
        if (groupDao.checkManager(managerUid, gid) == 0) {
            return new ManageResponse(-10);//不是管理员
        }

        //sb?
        if (managerUid == targetUid) {
            return new ManageResponse(-250);//不能踢出自己
        }

        //has apply?
        if (groupDao.removeApply(targetUid, gid) == 1) {
            return new ManageResponse(STATE_COMMON_OK);
        }

        //has member?
        if (groupDao.removeMember(targetUid, gid) == 1) {
            return new ManageResponse(STATE_COMMON_OK);
        }

        return new ManageResponse(STATE_COMMON_FAIL);
    }

    public InfoResponse getInfo(int uid, int gid) {
        DBgroup_info info = groupDao.getInfo(gid);
        if (info == null) {
            return new InfoResponse(-10, "", null, null, null);
        }
        boolean isMember = groupDao.checkMember(uid, gid) != 0;
        boolean isManager = groupDao.checkManager(uid, gid) != 0;

        List<InfoResponse.elmUser> memberList = null;
        List<InfoResponse.elmTask> taskList = null;
        List<InfoResponse.elmUser> applyList = null;

        if (isMember) {
            memberList = groupDao.getMemberOfGroup(gid);
            taskList = groupDao.getTaskOfGroup(gid);
        }

        if (isManager) {
            applyList = groupDao.getApplyList(gid);
        }

        return new InfoResponse(STATE_COMMON_OK, info.getGname(), memberList, taskList, applyList);

    }

}
