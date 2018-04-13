package xyz.veiasai.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.veiasai.util.MyIdDeserializer;
import xyz.veiasai.util.MyIdSerializer;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Document
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Order implements Serializable {

    @Id
    @JsonDeserialize(using = MyIdDeserializer.class)
    @JsonSerialize(using = MyIdSerializer.class)
    private BigInteger id;

    private List<Commodity> books;

    private String date;

    private Integer totalPrice;

    @Indexed
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

