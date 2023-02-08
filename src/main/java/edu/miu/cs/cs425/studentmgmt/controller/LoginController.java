package edu.miu.cs.cs425.studentmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/public/login")
    public String login() {
        return "public/login";
    }
}
