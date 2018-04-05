package xyz.veiasai.hibernate.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SingleBook;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CartResult extends Result {
    private List<SingleBook> Books;

    public List<SingleBook> getBooks() {
        return Books;
    }

    public void setBooks(List<SingleBook> books) {
        Books = books;
    }

    public void addBook(SingleBook singleBook){
        if (Books == null)
            Books = new ArrayList<SingleBook>();
        Books.add(singleBook);
    }
}
