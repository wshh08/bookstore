package com.rcospi.service;

import com.rcospi.domain.Category;

import java.util.List;

/**
 * 整个系统的核心业务接口
 *
 * @author wshh08
 */
public interface BusinessService {
    /**
     * 添加新分类
     * @param category 分类对象
     */
    void addCategory(Category category);

    /**
     * 修改分类
     * @param category 分类对象
     */
    void udateCategory(Category category);

    /**
     * 根据主键删除一个分类
     * @param categoryId 主键
     */
    void deleteCategory(String categoryId);

    /**
     * 根据主键查询一个分类
     * @param categoryId 分类主键
     * @return 结果
     */
    Category findCategoryById(String categoryId);

    /**
     * 查询所有分类
     * @return 结果集
     */
    List<Category> fiandAllCategories();
}
