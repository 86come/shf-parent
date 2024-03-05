package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SuppressWarnings({"unchecked","rawtypes"})
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "frame/index";
    }
    @GetMapping("/main")
    public String main(){
        return "frame/main";
    }

}
