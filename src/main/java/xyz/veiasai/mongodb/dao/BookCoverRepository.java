package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.Avatar;
import xyz.veiasai.mongodb.pojo.BookCover;

import java.awt.print.Book;
import java.math.BigInteger;

public interface BookCoverRepository extends MongoRepository<BookCover, BigInteger>{
    public BookCover findByUserID(Integer userID);
}
