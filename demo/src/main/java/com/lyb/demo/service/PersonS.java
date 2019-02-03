package com.lyb.demo.service;
import com.lyb.demo.mapper.PersonMapper;
import com.lyb.demo.model.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonS {
    @Resource
    private PersonMapper personM;

    public Person getPerson(Integer id){
        return personM.selectByPrimaryKey(id);
    }

    public int savePerson(Integer id,Integer age,String name){
        Person p = new Person();
        p.setId(id);
        p.setAge(age);
        p.setName(name);
        return personM.insert(p);
    }

    public int updatePerson(Integer id,Integer age,String name){
        Person p = personM.selectByPrimaryKey(id);
        p.setAge(age);
        p.setName(name);
        return personM.updateByPrimaryKey(p);
    }

    public int deletePerson(Integer id){
        return personM.deleteByPrimaryKey(id);
    }
}

