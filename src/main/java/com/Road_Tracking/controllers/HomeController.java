package com.Road_Tracking.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HomeController {

    @RequestMapping
    public String homePage() {
        return "home";
    }

}

