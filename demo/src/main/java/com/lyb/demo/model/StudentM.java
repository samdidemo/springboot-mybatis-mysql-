package com.lyb.demo.model;

public class StudentM {
    private String id;//学号

    private String name;//名字

    private String password;//密码

    private String adress;//地址

    private String school;//学院

    private String eron;//入学年份

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getEron() {
        return eron;
    }

    public void setEron(String eron) {
        this.eron = eron == null ? null : eron.trim();
    }
}