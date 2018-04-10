package xyz.veiasai.hibernate.mask;

import javax.validation.constraints.NotNull;

public class SingleCommodity {
    @NotNull
    private Integer bookID;

    @NotNull
    private Integer bookCount;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
