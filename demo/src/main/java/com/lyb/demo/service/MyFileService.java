package com.lyb.demo.service;

import com.github.pagehelper.PageHelper;
import com.lyb.demo.mapper.MyFileMapper;
import com.lyb.demo.model.MyFile;
import com.lyb.demo.model.TableSplitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFileService {
    @Autowired
    private MyFileMapper fileMapper;
    /**
     *分页查找账单
     * lyb
     */
    public TableSplitResult<List<MyFile>> selectAllByPage(int offset, int limit){
        List<MyFile> list0=fileMapper.selectAll();
        int size=list0.size();
        int offset2=offset/limit+1;//注意，一定要加1
        PageHelper.startPage(offset2,limit);//offset是第几页，limit是页面大小
        List<MyFile> list=fileMapper.selectAll();
        TableSplitResult<List<MyFile>> list1=new TableSplitResult<>();
        list1.setRows(list);
        list1.setPage(1);
        list1.setTotal(size);
        return list1;
    }
}
