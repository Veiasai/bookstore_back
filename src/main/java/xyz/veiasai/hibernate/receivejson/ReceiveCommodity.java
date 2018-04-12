package xyz.veiasai.hibernate.receivejson;

import javax.validation.constraints.NotNull;

public class ReceiveCommodity {
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
