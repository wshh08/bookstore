package com.rcospi.service;

import com.rcospi.domain.Book;
import com.rcospi.domain.Category;
import com.rcospi.web.bean.Page;

import java.util.List;

/**
 * 整个系统的核心业务接口
 *
 * @author wshh08
 */
public interface BusinessService {
    /**
     * 添加新分类
     *
     * @param category 分类对象
     */
    void addCategory(Category category);

    /**
     * 修改分类
     *
     * @param category 分类对象
     */
    void updateCategory(Category category);

    /**
     * 根据主键删除一个分类
     *
     * @param categoryId 主键
     */
    void deleteCategory(String categoryId);

    /**
     * 根据主键查询一个分类
     *
     * @param categoryId 分类主键
     * @return 结果
     */
    Category findCategoryById(String categoryId);

    /**
     * 查询所有分类
     *
     * @return 结果集
     */
    List<Category> findAllCategories();

    //--------书籍相关操作-----------------------

    /**
     * 添加图书
     * @param book 待添加书籍对象
     */
    void addBook(Book book);

    /**
     * 修改图书
     * @param book 待修改书籍对象
     */
    void updateBook(Book book);

    /**
     * 删除书籍
     * @param bookId 待删除书籍Id
     */
    void deleteBook(String  bookId);

    /**
     * 根据Id查询一本书
     * @param bookId 待查询书籍Id
     * @return 返回找到的书籍对象
     */
    Book findBookById(String  bookId);

    /**
     * 根据用户要看的页码进行图书的分页查询
     * @param num 页码
     * @return 保存分页信息的Page类对象
     */
    Page findPageBook(String num);

}
