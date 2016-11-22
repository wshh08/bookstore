package com.rcospi.dao.impl;

import com.rcospi.dao.BookDao;
import com.rcospi.domain.Book;

import java.util.List;

/**
 * Created by wshh08 on 16-11-20.
 */
public class BookDaoMysqlImpl implements BookDao {

    @Override
    public void save(Book book) {

    }

    @Override
    public Book findById(String bookId) {
        return null;
    }

    @Override
    public int findRecordsNum() {
        return 0;
    }

    @Override
    public List<Book> findBookRecords(int startIndex, int pageSize) {
        return null;
    }
}
