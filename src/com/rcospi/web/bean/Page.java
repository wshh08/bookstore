package com.rcospi.web.bean;

import java.util.List;

/**
 * 封装所有与分页有关的信息
 * Created by wshh08 on 16-11-20.
 */
public class Page {
    private List records;   // 页面内的记录
    private int pageNum;    // 用户要看的页码
    private int totalRecords;   // 总记录条数
    private int startIndex;     // 每页记录开始索引
    private int totalPage;  // 总页数
    private int pageSize = 3;   // 每页显示的记录条数

    public Page(int pageNum, int totalRecords) {
        this.pageNum = pageNum;
        this.totalRecords = totalRecords;

        startIndex = (pageNum - 1) * pageSize;  // 计算开始页码
        totalPage = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;   // 计算总页数

    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
