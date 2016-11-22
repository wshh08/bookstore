package com.rcospi.service.impl;

import com.rcospi.dao.BookDao;
import com.rcospi.dao.CategoryDao;
import com.rcospi.dao.impl.BookDaoMysqlImpl;
import com.rcospi.dao.impl.CategoryDaoMysqlImpl;
import com.rcospi.domain.Book;
import com.rcospi.domain.Category;
import com.rcospi.service.BusinessService;
import com.rcospi.web.bean.Page;

import java.util.List;
import java.util.UUID;

/**
 * Created by wshh08 on 16-11-20.
 */
public class BusinessServiceImpl implements BusinessService {

    private CategoryDao categoryDao = new CategoryDaoMysqlImpl();
    private BookDao bookDao = new BookDaoMysqlImpl();

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

    @Override
    public void addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookDao.save(book);
    }

    @Override
    public void updateBook(Book book) {
        throw new AbstractMethodError("暂未实现");
    }

    @Override
    public void deleteBook(String  bookId) {
        throw new AbstractMethodError("暂未实现");
    }

    @Override
    public Book findBookById(String  bookId) {
        return bookDao.findById(bookId);
    }

    @Override
    public Page findPageBook(String num) {
        int pageNum = 1;    // 默认页码值
        if (num != null && !num.equals("")) {
            pageNum = Integer.parseInt(num);
        }
        int totalRecords = bookDao.findRecordsNum();
        Page page = new Page(pageNum, totalRecords);
        List<Book> records = bookDao.findBookRecords(page.getStartIndex(), page.getPageSize());
        page.setRecords(records);
        return page;
    }
}





















