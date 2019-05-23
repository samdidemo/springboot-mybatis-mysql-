package com.lyb.demo.controller;

import com.lyb.demo.model.MyFile;
import com.lyb.demo.model.TableSplitResult;
import com.lyb.demo.service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class fileController {
    @Autowired
    private MyFileService fileService;
    @GetMapping(value = "/file/page")
    @ResponseBody
    public TableSplitResult<List<MyFile>> findFile(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
        return fileService.selectAllByPage(offset,limit);
    }
}
