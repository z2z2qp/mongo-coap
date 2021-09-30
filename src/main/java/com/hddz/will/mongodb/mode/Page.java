package com.hddz.will.mongodb.mode;

import java.util.List;

/**
 * com.hddz.will.mongodb.mode.Page
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/9/9 8:57
 */
public class Page<T> {

    private int page;
    private int rows;
    private long total;
    private List<T> data;

    public Page() {
    }

    public Page(int page, int rows, long total, List<T> data) {
        this.page = page;
        this.rows = rows;
        this.total = total;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
