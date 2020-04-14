package com.demo.asset.controller;

import com.demo.asset.entity.User;
import com.demo.asset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String user() {
        return "user";
    }

    @PostMapping("/{name}")
    @ResponseBody
    public ResponseEntity<?> password(@PathVariable("name") String name, String password) {
        User user = userService.find(name);
        user.setPassword(password);
        userService.save(user);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
