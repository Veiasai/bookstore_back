package xyz.veiasai.hibernate.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SaleRecord;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SaleRecordResult extends Result {

    private List<SaleRecord> records;
    private Integer pagesize;
    private Integer page;

    public List<SaleRecord> getRecords() {
        return records;
    }

    public void setRecords(List<SaleRecord> records) {
        this.records = records;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
