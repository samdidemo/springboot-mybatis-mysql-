package com.lyb.demo.controller;

import com.lyb.demo.model.Money;
import com.lyb.demo.model.TableSplitResult;
import com.lyb.demo.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class moneyController {
    @Autowired
    private MoneyService moneyService;
    @GetMapping(value = "/money/page")
    @ResponseBody
    public TableSplitResult<List<Money>> selectMoneyByPage(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
        return moneyService.selectAllByPage(offset,limit);
    }
}
