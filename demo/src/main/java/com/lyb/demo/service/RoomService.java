package com.lyb.demo.service;

import com.lyb.demo.mapper.RoomMapper;
import com.lyb.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查找所有的房间
     * lyb
     * 2019.2.6
     * @return
     */
    public List<Room> selectAllRoom(){
        return roomMapper.selectAll();
    }
}
