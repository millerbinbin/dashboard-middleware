package com.jd.logistics.cloud.data.dashboard.commons.page;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/27 21:47
 */
public class PageRequest implements Serializable {
    private static final long serialVersionUID = -2959044827323493348L;
    private int page = 1;
    private int pageSize = 10;

    public PageRequest() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getOffset() {
        return (long) (this.page - 1) * (long) this.pageSize;
    }
}