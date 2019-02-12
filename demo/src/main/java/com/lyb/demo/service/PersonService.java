package com.lyb.demo.service;
import com.lyb.demo.mapper.PersonMapper;
import com.lyb.demo.model.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    public Person getPerson(Integer id){
        return personMapper.selectByPrimaryKey(id);
    }

    public int savePerson(Integer id,Integer age,String name){
        Person p = new Person();
        p.setId(id);
        p.setAge(age);
        p.setName(name);
        p.setIfmember(0);
        return personMapper.insert(p);
    }

    public int updatePerson(Integer id,Integer age,String name){
        Person p = personMapper.selectByPrimaryKey(id);
        p.setAge(age);
        p.setName(name);
        return personMapper.updateByPrimaryKey(p);
    }

    public int deletePerson(Integer id){
        return personMapper.deleteByPrimaryKey(id);
    }
}

