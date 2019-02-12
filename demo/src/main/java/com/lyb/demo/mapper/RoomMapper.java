package com.lyb.demo.mapper;

import com.lyb.demo.model.Room;

import java.util.List;

public interface RoomMapper {
    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectAll();

    int updateRoomStatus(String id);

    int selectRoomPrice(String id);
}