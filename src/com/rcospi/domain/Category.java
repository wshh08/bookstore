package com.rcospi.domain;

import java.io.Serializable;

/**
 * 用来描述书记分类的实体类(JavaBean)
 * @author wshh08
 */
public class Category implements Serializable {
    private String id;  // 分类主键
    private String name; // 分类名称
    private String description; // 分类描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
