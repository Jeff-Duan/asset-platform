package com.demo.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpSession session;

    @GetMapping
    public String home() {
        return "home";
    }

}
