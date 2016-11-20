package com.rcospi.service.impl;

import com.rcospi.dao.CategoryDao;
import com.rcospi.dao.impl.CategoryDaoMysqlImpl;
import com.rcospi.domain.Category;
import com.rcospi.service.BusinessService;

import java.util.List;
import java.util.UUID;

/**
 * Created by wshh08 on 16-11-20.
 */
public class BusinessServiceImpl implements BusinessService {

    private CategoryDao categoryDao = new CategoryDaoMysqlImpl();

    @Override
    public void addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());   // 新添加category时的categoryId在此处生成
        categoryDao.add(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryDao.delete(categoryId);
    }

    @Override
    public Category findCategoryById(String categoryId) {
        return categoryDao.findOne(categoryId);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }
}
