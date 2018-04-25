package xyz.veiasai.hibernate.receivejson;

import java.util.List;

public class SearchBook {
    private String searchText;
    private List<Integer> priceRange;
    private List<String> dateRange;
    private String bookClass;
    private Boolean bookValid;
    private Integer pageSize;
    private Integer page;

    public Boolean getBookValid() {
        return bookValid;
    }

    public void setBookValid(Boolean bookValid) {
        this.bookValid = bookValid;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Integer> getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(List<Integer> priceRange) {
        this.priceRange = priceRange;
    }

    public List<String> getDateRange() {
        return dateRange;
    }

    public void setDateRange(List<String> dateRange) {
        this.dateRange = dateRange;
    }

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
