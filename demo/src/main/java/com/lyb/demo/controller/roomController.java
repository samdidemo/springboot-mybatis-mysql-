package com.lyb.demo.controller;

import com.github.pagehelper.PageHelper;
import com.lyb.demo.model.Order;
import com.lyb.demo.model.Room;
import com.lyb.demo.model.TableSplitResult;
import com.lyb.demo.service.RoomService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class roomController {
    @Autowired
    private  RoomService roomService;
    @ApiOperation(value="查找所有房间")
    @GetMapping(value = "/room/all")
    @ResponseBody
    public List<Room> selectAllRoom(){
        return roomService.selectAllRoom();
    }

    @ApiOperation(value="分页查找房间",notes = "根据页面大小和页数")
    @ApiImplicitParam(name = "offset",dataType = "int")
    @GetMapping(value = "/room/page")
    @ResponseBody
    public TableSplitResult<List<Room>> getRoomByPage(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
        List<Room> list0=roomService.selectAllRoom();
        int size=list0.size();
        int offset2=offset/limit+1;//注意，一定要加1
        PageHelper.startPage(offset2,limit);//offset是第几页，limit是页面大小
        List<Room> list=roomService.selectAllRoom();
        TableSplitResult<List<Room>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(size);
        return list1;

    }
    @GetMapping(value ="/update/room/{id}/{status}")
    @ResponseBody
    public int updateRoomStatus(@PathVariable("id")String id,@PathVariable("status")String status){
        return roomService.updateRoomStatus(status,id);
    }
}
