package xyz.veiasai.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private BigInteger id;

    @Indexed
    @JsonIgnore
    private Integer index;

    private List<Integer> bookIDs;

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

    public List<Integer> getBookIDs() {
        return bookIDs;
    }

    public void setBookIDs(List<Integer> bookIDs) {
        this.bookIDs = bookIDs;
    }
}
