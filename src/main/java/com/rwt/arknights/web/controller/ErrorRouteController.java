package com.rwt.arknights.web.controller;

import com.rwt.arknights.web.bean.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@RequestMapping("/error")
public class ErrorRouteController   {

    @RequestMapping("/404")
    public String notFind() {
        return "error/404";
    }

    @RequestMapping("/500")
    public String error500() {
        return "error/500";
    }
}