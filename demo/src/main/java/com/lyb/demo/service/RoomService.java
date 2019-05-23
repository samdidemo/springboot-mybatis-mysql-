package com.lyb.demo.service;

import com.lyb.demo.mapper.RoomMapper;
import com.lyb.demo.model.Room;
import com.lyb.demo.util.Dateutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private ApplicationContext context;


    /**
     * 查找所有的房间
     * lyb
     * 2019.2.6
     * @return
     */
    public List<Room> selectAllRoom(){
        return roomMapper.selectAll();
    }

    public int updateRoomStatus(String id,String status){
        return roomMapper.updateRoomStatus(status,id);
    }
    @Bean
    public Dateutil getDateUntil(){
        return new Dateutil();
    }
    public void test() {
        Dateutil dateutil = (Dateutil) context.getBean("getDateUntil");
        System.out.println(dateutil.test());
    }
}
