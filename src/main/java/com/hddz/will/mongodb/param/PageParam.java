package com.hddz.will.mongodb.param;

/**
 * com.hddznet.finecomm.unlink.params.PageParam
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/28 9:41
 */
public class PageParam {

    private int page;
    private int rows;

    public PageParam(){
        this.page = 1;
        this.rows = 10;
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
}
