package com.lyb.demo.mapper;

import com.lyb.demo.model.Money;

public interface MoneyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Money record);

    int insertSelective(Money record);

    Money selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);
    int selectTotalMoney();
}