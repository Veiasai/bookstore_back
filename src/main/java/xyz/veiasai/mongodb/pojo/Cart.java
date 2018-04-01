package xyz.veiasai.mongodb.pojo;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
public class Cart implements Serializable {

    private Integer id;

    private List<CartBook> books = new ArrayList<CartBook>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartBook> getBooks() {
        return books;
    }

    public void setBooks(List<CartBook> books) {
        this.books = books;
    }
}
