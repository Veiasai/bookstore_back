package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

import java.math.BigInteger;

public interface BookImgRepository extends MongoRepository<BookImgAndDescrption, BigInteger> {

    public BookImgAndDescrption findByBookid(Integer bookid);
}
