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

    @RequestMapping("/picupload")
    public PicUploadResponse picUpload(PicUploadRequire req){

        System.out.println(req.getUid());
        System.out.println(req.getToken());
        System.out.println(req.getPic());

        if (!userService.checkUser(req)) {
            return new PicUploadResponse(STATE_COMMON_FAIL,"");
        }

        if (req.getPic() == null || req.getPic().isEmpty()){
            return new PicUploadResponse(-2,"");
        }

        return rcdService.picUpload(req.getUid(),req.getPic());
    }

}
