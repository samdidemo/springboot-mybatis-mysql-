package com.lyb.demo.mapper;

import com.lyb.demo.model.StudentM;

import java.util.List;

/**
 * 学生
 */
public interface StudentMMapper {
    int insert(StudentM record);

    int insertSelective(StudentM record);

    List<StudentM> selectAllM();

    StudentM selectByid(String id);

    String findMaxId();

    Boolean deleteStudById(String id);
}