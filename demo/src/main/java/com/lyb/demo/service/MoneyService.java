package com.lyb.demo.service;

import com.github.pagehelper.PageHelper;
import com.lyb.demo.mapper.MoneyMapper;
import com.lyb.demo.model.Money;
import com.lyb.demo.model.Order;
import com.lyb.demo.model.TableSplitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {
    @Autowired
    private MoneyMapper moneyMapper;
    /**
     *查找所有账单
     * lyb
     */
    public List<Money> selectAll(){
        return moneyMapper.selectAll();
    }
    /**
     *分页查找账单
     * lyb
     */
    public TableSplitResult<List<Money>> selectAllByPage(int offset,int limit){
        List<Money> list0=moneyMapper.selectAll();
        int size=list0.size();
        int offset2=offset/limit+1;//注意，一定要加1
        PageHelper.startPage(offset2,limit);//offset是第几页，limit是页面大小
        List<Money> list=moneyMapper.selectAll();
        TableSplitResult<List<Money>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(size);
        return list1;
    }

}
