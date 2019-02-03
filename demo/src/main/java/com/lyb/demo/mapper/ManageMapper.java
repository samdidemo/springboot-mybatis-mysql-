package com.lyb.demo.mapper;

import com.lyb.demo.model.Manage;

import java.util.List;

public interface ManageMapper {
    int insert(Manage record);

    int insertSelective(Manage record);
    String selectPassword(String username);
    List<Manage> selectAll();
}