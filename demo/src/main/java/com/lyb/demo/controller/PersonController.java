package com.lyb.demo.controller;
import com.lyb.demo.model.Person;
import com.lyb.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class PersonController {

    @Resource
    private PersonService personS;
    //增加
    @PostMapping(value="/person")
    public int savePerson(@RequestParam("id") Integer id,@RequestParam("age") Integer age,@RequestParam("name") String name){
        return personS.savePerson(id,age,name);
    }
    //访问
    @GetMapping(value="/person/{id}")
    public Person getPerson(@PathVariable("id") Integer id){
        return personS.getPerson(id);
    }
    //修改
    @PutMapping(value="/person/{id}")
    public int updatePerson(@PathVariable("id") Integer id,@RequestParam("age") Integer age,@RequestParam("name") String name){
        return personS.updatePerson(id,age,name);
    }
    //删除
    @DeleteMapping(value="/person/{id}")
    public int deletePerson(@PathVariable("id")Integer id){
        return personS.deletePerson(id);
    }
}
