package com.lyb.demo.model;

import java.io.Serializable;

/**
 * 泛型，用于返回bootstrap所要求的格式
 * lyb
 * 2019.1.28
 * @param <T>
 */
public class TableSplitResult<T> implements Serializable {

    private  Integer page;
    private Integer total;
    private T rows;


    public TableSplitResult() {
    }

    public TableSplitResult(Integer page, Integer total, T rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }
}
