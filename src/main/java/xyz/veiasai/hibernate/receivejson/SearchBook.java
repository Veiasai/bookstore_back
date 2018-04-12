package xyz.veiasai.hibernate.receivejson;

import java.util.List;

public class SearchBook {
    private String searchtext;
    private List<Integer> PriceRange;
    private List<String> DateRange;
    private String bookClass;
    private Integer pagesize;
    private Integer page;

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public List<Integer> getPriceRange() {
        return PriceRange;
    }

    public void setPriceRange(List<Integer> priceRange) {
        PriceRange = priceRange;
    }

    public List<String> getDateRange() {
        return DateRange;
    }

    public void setDateRange(List<String> dateRange) {
        DateRange = dateRange;
    }

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
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
