package com.bjtu.timeline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/nologin")
    public String Test(){
        return "nologin ok";
    }

    @ResponseBody
    @RequestMapping("/needlogin")
    public String Testb(){
        return "needlogin ok";
    }

}
