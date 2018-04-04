package xyz.veiasai.hibernate.server;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SingleBook;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookResult implements Result {
    private List<String> message = new ArrayList();
    List<SingleBook> Books;
    private Integer timeID;
    private Integer code;

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
