package com.hddz.will.mongodb.mode;

import java.util.List;

public class PageMessage<T> {

    private long curr;
    private List<T> data;
    private int rows;
    private long count;

    public PageMessage(long curr,List<T> data,int rows,long count){
        this.curr = curr;
        this.data = data;
        this.rows = rows;
        this.count = count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setCurr(long curr) {
        this.curr = curr;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public long getCount() {
        return count;
    }

    public long getCurr() {
        return curr;
    }

    public List<T> getData() {
        return data;
    }

    public int getRows() {
        return rows;
    }

}