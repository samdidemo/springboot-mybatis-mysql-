package com.lyb.demo.controller;

import com.lyb.demo.mapper.ManageMapper;
import com.lyb.demo.mapper.OrderMapper;
import com.lyb.demo.mapper.StudentMMapper;
import com.lyb.demo.model.Manage;
import com.lyb.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class textController {
    @Autowired
    private ManageMapper manageMapper;
    @Autowired
    private StudentMMapper studentMapper;
    @Autowired
    private OrderMapper orderMapper;
    @GetMapping(value = "/")
    public String login(){
        return "prosceniumIndex";
    }
    @GetMapping(value = "/login1")
    public String login1(){
        return "welcome";
    }
    @GetMapping(value = "/manage/student")
    public String manageStudent1(){
        return "studentList";
    }
    @GetMapping(value = "/user")
    public String user(){
        return "user";
    }
    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping(value = "/maps")
    public String maps(){
        return "maps";
    }
    @GetMapping(value = "/upgrade")
    public String upgrade(){
        return "upgrade";
    }
    @GetMapping(value = "/typography")
    public String typography(){
        return "typography";
    }
    @GetMapping(value = "/template")
    public String template(){
        return "template";
    }
    @GetMapping(value = "/table")
    public String table(){
        return "table";
    }
    @GetMapping(value = "/notifications")
    public String notifications(){
        return "notifications";
    }
    @GetMapping(value = "/icons")
    public String icons(){
        return "icons";
    }
    @GetMapping(value = "/1")
    public String icons1(){
        return "thetext";
    }







    /**
     * 管理员登录
     * lyb
     * 未完善
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public String login1(@RequestParam("userName") String username,@RequestParam("password") String password){
        String password1=manageMapper.selectPassword(username);
        if(password1.equals(password)){
            return "notifications";
        }else
            return "redirect:/login1";
    }

    @GetMapping(value = "/login2")
    public String login2(){
        return "flase";
    }
   @GetMapping(value = "/manage/All")
    @ResponseBody
    public List<Manage> selectAll(){
        return manageMapper.selectAll();
    }

}
