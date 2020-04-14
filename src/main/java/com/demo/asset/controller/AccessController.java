package com.demo.asset.controller;

import com.demo.asset.entity.User;
import com.demo.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/access")
public class AccessController {

    @Autowired
    HttpSession session;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String name, String password) {
        User user = userService.find(name, password);
        if (user != null) {
            session.setAttribute("hasLogin", true);
            session.setAttribute("userName", user.getName());
            session.setAttribute("userRole", user.isRole());
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/access/login";
    }

}
