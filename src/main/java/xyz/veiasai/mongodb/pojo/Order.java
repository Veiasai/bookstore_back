package xyz.veiasai.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Document
public class Order implements Serializable {
    @Id
    @JsonIgnore
    private BigInteger id;

    @JsonIgnore
    @Indexed
    private Integer index;

    private List<Commodity> books;

    private String date;

    private Integer totalPrice;

    private Integer userID;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Commodity> getBooks() {
        return books;
    }

    public void setBooks(List<Commodity> books) {
        this.books = books;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
