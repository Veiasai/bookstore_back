package xyz.veiasai.mongodb.pojo;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document
public class Cart implements Serializable {

    private Integer id;

    private Set<CartBook> books = new HashSet<CartBook>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<CartBook> getBooks() {
        return books;
    }

    public void setBooks(Set<CartBook> books) {
        this.books = books;
    }
}
