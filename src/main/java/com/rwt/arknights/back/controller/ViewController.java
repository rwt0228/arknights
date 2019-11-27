package com.rwt.arknights.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/operator")
    public String operator( ){
        return "back/operator";
    }
}
