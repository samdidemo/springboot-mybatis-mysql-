package com.lyb.demo.mapper;

import com.lyb.demo.model.MyFile;

import java.util.List;

public interface MyFileMapper {
    int insert(MyFile record);

    int insertSelective(MyFile record);

    List<MyFile> selectAll();
}