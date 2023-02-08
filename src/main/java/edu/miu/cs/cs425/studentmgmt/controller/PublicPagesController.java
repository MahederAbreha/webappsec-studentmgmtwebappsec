package edu.miu.cs.cs425.studentmgmt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PublicPagesController {

    @GetMapping(value = "/")
    public String displayHomePage() {
        return "public/index";
    }
}
