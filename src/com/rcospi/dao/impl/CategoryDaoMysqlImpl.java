package com.rcospi.dao.impl;

import com.rcospi.dao.CategoryDao;
import com.rcospi.domain.Category;
import com.rcospi.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wshh08 on 16-11-20.
 */
public class CategoryDaoMysqlImpl implements CategoryDao {

    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    @Override
    public List<Category> findAll() {
        try {
            return qr.query("SELECT * FROM category", new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }

    @Override
    public Category findOne(String categoryId) {
        if (categoryId == null || categoryId.trim().equals(""))
            throw new IllegalArgumentException("The param categoryId cannot be empty");
        try {
            return qr.query("SELECT * FROM category WHERE id=?", new BeanHandler<>(Category.class),categoryId);
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }

    @Override
    public void delete(String categoryId) {
        if (categoryId == null || categoryId.trim().equals(""))
            throw new IllegalArgumentException("The param categoryId cannot be empty");
        try {
            qr.update("DELETE FROM category WHERE id=?", categoryId);
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }

    @Override
    public void update(Category category) {
        if (category == null)
            throw new IllegalArgumentException("The param category cannot be null");
        try {
            qr.update("UPDATE category SET name=?, description=? WHERE id=?", category.getName(), category.getDescription(), category.getId());
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }

    @Override
    public void add(Category category) {
        if (category == null)
            throw new IllegalArgumentException("The param category cannot be null");
        try {
            qr.update("INSERT INTO category(id, name, description) VALUES(?, ?, ?)", category.getId(), category.getName(), category.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }
}
