package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    private Long total;
    private List rows;

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {

        return total;
    }

    public List getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
