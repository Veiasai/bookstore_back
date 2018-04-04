package xyz.veiasai.hibernate.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class SingleBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookID;

    @NotEmpty
    @Column
    private String bookName;

    @NotNull
    @DecimalMax("999")
    @DecimalMin("1")
    @Column
    private Integer bookPrice;

    @NotNull
    @DecimalMax("999")
    @DecimalMin("0")
    @Column
    private Integer bookStock;

    @NotEmpty
    @Column
    private String bookWriter;

    @NotEmpty
    @Column
    private String bookDate;

    @NotEmpty
    @Column
    private String bookClass;

    @NotNull
    @Column
    private Boolean valid;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
