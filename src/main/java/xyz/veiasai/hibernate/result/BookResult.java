package xyz.veiasai.hibernate.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookResult extends Result {

    private List<SingleBook> Books;
    private SingleBook singleBook;
    private BookImgAndDescrption bookImgAndDescrption;
    private Integer pagesize;
    private Integer page;

    public SingleBook getSingleBook() {
        return singleBook;
    }

    public void setSingleBook(SingleBook singleBook) {
        this.singleBook = singleBook;
    }

    public BookImgAndDescrption getBookImgAndDescrption() {
        return bookImgAndDescrption;
    }

    public void setBookImgAndDescrption(BookImgAndDescrption bookImgAndDescrption) {
        this.bookImgAndDescrption = bookImgAndDescrption;
    }

    public List<SingleBook> getBooks() {
        return Books;
    }

    public void setBooks(List<SingleBook> books) {
        Books = books;
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
