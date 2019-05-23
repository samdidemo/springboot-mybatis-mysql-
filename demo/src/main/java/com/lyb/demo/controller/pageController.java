package com.lyb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class pageController {
    @GetMapping(value = "/proscenium")
    public String proscenium(){
        return "prosceniumIndex";
    }

    @GetMapping(value = "/loging")
    public String loging(){
        return "loging";
    }
}
