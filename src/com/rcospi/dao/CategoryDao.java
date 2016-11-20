package com.rcospi.dao;

import com.rcospi.domain.Category;

import java.util.List;

/**
 * Created by wshh08 on 16-11-20.
 */
public interface CategoryDao {
    List<Category> findAll();

    Category findOne(String categoryId);

    void delete(String categoryId);

    void update(Category category);

    void add(Category category);
}
