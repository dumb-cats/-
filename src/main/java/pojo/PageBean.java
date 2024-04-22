package pojo;

import java.util.List;

public class PageBean {
    private int totalCount;
    private List<Song> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Song> getRows() {
        return rows;
    }

    public void setRows(List<Song> rows) {
        this.rows = rows;
    }
}
