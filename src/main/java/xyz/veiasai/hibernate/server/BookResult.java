package xyz.veiasai.hibernate.server;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookResult implements Result {
    private List<String> message = new ArrayList();
    private List<SingleBook> Books;
    private SingleBook singleBook;
    private BookImgAndDescrption bookImgAndDescrption;

    private Integer timeID;
    private Integer code;

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

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Integer getTimeID() {
        return timeID;
    }

    public void setTimeID(Integer timeID) {
        this.timeID = timeID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void addMessage(String in) {
        message.add(in);
    }
}
