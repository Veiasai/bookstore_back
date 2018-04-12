package xyz.veiasai.hibernate.receivejson;

import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class ReceiveBook {
    @NotNull
    @Valid
    private SingleBook singleBook;

    @NotNull
    @Valid
    private BookImgAndDescrption bookImgAndDescrption;

    public SingleBook getSingleBook() {
        return singleBook;
    }

    public void setSingleBook(SingleBook singleBook) {
        this.singleBook = singleBook;
    }

    public BookImgAndDescrption getBookImgAndDescrption() {
        return bookImgAndDescrption;
    }

    public void setBookImgAndDescrption(BookImgAndDescrption bookImgAndDescrption) {
        this.bookImgAndDescrption = bookImgAndDescrption;
    }
}
