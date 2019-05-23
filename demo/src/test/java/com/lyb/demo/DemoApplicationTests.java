package com.lyb.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Test
//    public void contextLoads() {
//        List<Student> list=studentMapper.selectAll();
//        for(Student i:list){
//            System.out.print(i.getName()+i.getAdress()+i.getId());
//            System.out.print("ddddddd");
//
//        }
//    }
    @Test
    public void test(){
        System.out.println("fff");
    }

}

