package com.rcospi.test;

import com.rcospi.domain.Category;
import com.rcospi.service.BusinessService;
import com.rcospi.service.impl.BusinessServiceImpl;

import java.util.List;

/**
 * Created by wshh08 on 16-11-20.
 */
public class BusinessServiceImplTest {

    private BusinessService s = new BusinessServiceImpl();

    @org.junit.Test
    public void addCategory() throws Exception {
        Category category = new Category();
        category.setName("Java编程类");
        category.setDescription("走向高薪高富帅之路");
        s.addCategory(category);
    }

    @org.junit.Test
    public void updateCategory() throws Exception {
        Category c = s.findCategoryById("95603379-af41-4516-a4ee-c8bf1cdca86f");
        c.setDescription("高富帅摇篮");
        s.updateCategory(c);
    }

    @org.junit.Test
    public void findCategoryById() throws Exception {
        Category category = s.findCategoryById("95603379-af41-4516-a4ee-c8bf1cdca86f");
        System.out.println(category.getName());
    }

    @org.junit.Test
    public void findAllCategories() throws Exception {
        List<Category> cs = s.findAllCategories();
        for (Category c : cs)
            System.out.println(c.getName());
    }

    @org.junit.Test
    public void deleteCategory() throws Exception {
        s.deleteCategory("95603379-af41-4516-a4ee-c8bf1cdca86f");
    }

}