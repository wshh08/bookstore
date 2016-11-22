package com.rcospi.dao;

import com.rcospi.domain.Book;
import java.util.List;

/**
 * 用于操作book表的DAO
 */
public interface BookDao {

    void save(Book book);

    Book findById(String bookId);

    int findRecordsNum();

    List<Book> findBookRecords(int startIndex, int pageSize);
}
