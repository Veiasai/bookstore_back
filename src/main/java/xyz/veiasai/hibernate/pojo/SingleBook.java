package xyz.veiasai.hibernate.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import xyz.veiasai.util.groups.update;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class SingleBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookID;


    @NotEmpty(message = "bookName can't be empty")
    @Column
    private String bookName;

    @NotNull(message = "bookPrice can't be null")
    @DecimalMax(value = "999",message = "bookPrice > 999")
    @DecimalMin(value = "0",message = "bookPrice < 1")
    @Column
    private Integer bookPrice;

    @NotNull(groups = {update.class})
    @DecimalMax(value = "999",message = "bookStock > 999")
    @DecimalMin(value = "0",message = "bookStock < 1")
    @Column
    private Integer bookStock;

    @NotEmpty(message = "bookWriter can't be empty")
    @Column
    private String bookWriter;

    @NotEmpty(message = "bookDate can't be empty")
    @Column
    private String bookDate;

    @NotEmpty(message = "bookClass can't be empty")
    @Column
    private String bookClass;

    @NotNull(groups = {update.class},message = "valid can't be null")
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
