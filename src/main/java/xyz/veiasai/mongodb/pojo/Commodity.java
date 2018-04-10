package xyz.veiasai.mongodb.pojo;

import org.springframework.data.mongodb.core.index.Indexed;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.util.groups.update;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Commodity {
    public Commodity() {
    }

    public Commodity(SingleBook singleBook, Integer count) {
        this.bookID = singleBook.getBookID();
        this.bookName = singleBook.getBookName();
        this.bookDate = singleBook.getBookDate();
        this.bookClass = singleBook.getBookClass();
        this.bookPrice = singleBook.getBookPrice();
        this.bookWriter = singleBook.getBookWriter();
        this.bookCount = count;
        this.bookTotalPrice = this.bookPrice * count;
    }
    private Integer bookID;

    private String bookName;

    private Integer bookPrice;

    private Integer bookCount;

    private String bookWriter;

    private String bookDate;

    private String bookClass;

    private Integer bookTotalPrice;

    public Integer getBookTotalPrice() {
        return bookTotalPrice;
    }

    public void setBookTotalPrice(Integer bookTotalPrice) {
        this.bookTotalPrice = bookTotalPrice;
    }

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

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
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


}
