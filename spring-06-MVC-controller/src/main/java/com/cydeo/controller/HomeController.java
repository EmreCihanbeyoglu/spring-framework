package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // stereotype annotation - this cover "@component" annotation
public class HomeController {

    @RequestMapping("/home") // associate the request path with html page which will be returned to this request
    public String home(){
        return "home.html";
    }

    @RequestMapping("/home")
    public String home2(){
        return "home.html";
    }

    @RequestMapping // if you don't specify any path, then default one is "/"
    public String home3(){
        return "home.html"; // this should be the path to view from static folder
    }

}
