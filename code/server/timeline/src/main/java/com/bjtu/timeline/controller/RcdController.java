package com.bjtu.timeline.controller;

import com.bjtu.timeline.bean.require.RcdRequires.*;
import com.bjtu.timeline.bean.response.RcdResponses.*;
import com.bjtu.timeline.service.RcdService;
import com.bjtu.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rcd")
public class RcdController {

    @Autowired
    private RcdService rcdService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ListResponse list(ListRequire req) {
        if (!userService.checkUser(req)) {
            return new ListResponse(STATE_COMMON_FAIL, null);
        }
        return rcdService.getList(req.getUid());
    }

    @RequestMapping("/view")
    public ViewResponse list(ViewRequire req) {
        if (!userService.checkUser(req)) {
            return new ViewResponse(STATE_COMMON_FAIL, -1, null, -1, null, null);
        }
        return rcdService.getSingel(req.getUid(), req.getRid());
    }

    @RequestMapping("/upd")
    public UpdResponse list(UpdRequire req) {
        if (!userService.checkUser(req)) {
            return new UpdResponse(STATE_COMMON_FAIL);
        }
        return rcdService.updateRecord(
                req.getUid(),
                req.getRid(),
                req.getTitle(),
                req.getTime(),
                req.getDetail(),
                req.getPicture()
        );
    }

    @RequestMapping("/add")
    public AddResponse add(AddRequire req) {
        if (!userService.checkUser(req)) {
            return new AddResponse(STATE_COMMON_FAIL);
        }
        return rcdService.addRecord(
                req.getUid(),
                req.getTitle(),
                req.getTime(),
                req.getDetail(),
                req.getPicture()
        );
    }

    @RequestMapping("/picupload")
    public PicUploadResponse picUpload(PicUploadRequire req) {

        if (!userService.checkUser(req)) {
            return new PicUploadResponse(STATE_COMMON_FAIL, "");
        }

        if (req.getPic() == null || req.getPic().isEmpty()) {
            return new PicUploadResponse(-2, "");
        }

        return rcdService.picUpload(req.getUid(), req.getPic());
    }

}
