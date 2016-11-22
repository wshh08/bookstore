package com.rcospi.domain;

import java.io.Serializable;

/**
 * Created by wshh08 on 16-11-20.
 */
public class Book implements Serializable {
    private String  id; // 主键
    private String name;    // 书名
    private String author;  // 作者
    private float money;    // 单价
    private String description; // 描述
    private String path;    // 存放图片文件的目录
    private String oldImageName;    // 原文件名(显示时的文件名)
    private String newImageName;    // 新文件名(为了防止重名生成的随机文件名)

    // 书和分类应该设置成多对一还是一对多呢？由于需求是按分类显示书籍，理论上应该在分类中保存书籍
    // 但是由于没有ORM框架，先按多对一(在书籍中保存分类信息)设计
    private String categoryId;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOldImageName() {
        return oldImageName;
    }

    public void setOldImageName(String oldImageName) {
        this.oldImageName = oldImageName;
    }

    public String getNewImageName() {
        return newImageName;
    }

    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
