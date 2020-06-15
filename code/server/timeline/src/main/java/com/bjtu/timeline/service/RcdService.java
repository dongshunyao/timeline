package com.bjtu.timeline.service;

import com.bjtu.common.StringUtil;
import com.bjtu.timeline.bean.response.RcdResponses.*;
import com.bjtu.timeline.mapper.RcdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_FAIL;
import static com.bjtu.timeline.bean.response.CommonResponses.STATE_COMMON_OK;

@Service
public class RcdService {

    @Autowired
    private RcdMapper rcdDao;

    @Value("${config-string.picture-path}")
    private String picturePrefix;

    private static final Set<String> okSuffix = new HashSet<String>() {{
        add("jpg");add("png");add("bmp");
    }};

    public ListResponse getList(int uid){
        List<ListResponse.listElm> list = rcdDao.getListByUid(uid);
        return new ListResponse(STATE_COMMON_OK,list);
    }

    public PicUploadResponse picUpload(int uid, MultipartFile file){
        String picPath = picturePrefix + uid + "\\" ;
        File father = new File(picPath);
        if(! father.exists()){
            father.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        String pictureSuffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        String innerName = "";
        if(! okSuffix.contains(pictureSuffix)){
            return new PicUploadResponse(-10,"");
        }

        File outPicture = null;
        FileOutputStream fos = null;
        do {
            innerName = StringUtil.getRandString();
            String picturePath = picPath + innerName + "." + pictureSuffix;
            System.out.println(picturePath);
            outPicture = new File(picturePath);
        } while(outPicture.exists());

        try {
            outPicture.createNewFile();
            fos = new FileOutputStream(outPicture);
            fos.write(file.getBytes());
            return new PicUploadResponse(0,"" + uid + "/" + innerName + "." + pictureSuffix);
        } catch (Exception ignored) {}
        finally {
            try {
                fos.close();
            } catch (Exception ignored){}
        }

        return new PicUploadResponse(-20,"");

    }

}
