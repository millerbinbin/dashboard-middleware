package com.fresh.commons.data.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/27 21:46
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 2489970337451484305L;
    private long totalElements = 0L;
    private int size = 10;
    private int page = 1;
    private List<T> content = new ArrayList();

    public Page() {
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPage() {
        return this.totalElements / (long) this.size + (long) (this.totalElements % (long) this.size == 0L ? 0 : 1);
    }

    public List<T> getContent() {
        return this.content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
