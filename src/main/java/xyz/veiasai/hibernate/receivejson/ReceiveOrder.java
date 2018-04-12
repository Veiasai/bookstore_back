package xyz.veiasai.hibernate.receivejson;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class ReceiveOrder {
    @NotNull
    @Valid
    private List<ReceiveCommodity> books;

    @NotEmpty(message = "date can'be empty")
    private String date;

    public List<ReceiveCommodity> getBooks() {
        return books;
    }

    public void setBooks(List<ReceiveCommodity> books) {
        this.books = books;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
