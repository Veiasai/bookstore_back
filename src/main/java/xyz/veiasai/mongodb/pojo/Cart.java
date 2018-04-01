package xyz.veiasai.mongodb.pojo;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document
public class Cart implements Serializable {

    @Id
    private BigInteger id;
    @Indexed
    private Integer index;

    private List<CartBook> books = new ArrayList<CartBook>();

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

    public List<CartBook> getBooks() {
        return books;
    }

    public void setBooks(List<CartBook> books) {
        this.books = books;
    }
}
