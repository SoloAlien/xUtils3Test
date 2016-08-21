package com.example.alien.xutilstest;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Alien on 2016/8/19.
 */
@Table(name = "student")//表名
public class Student {
    @Column(name = "id", isId = true)//列名，id属性必须添加
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
