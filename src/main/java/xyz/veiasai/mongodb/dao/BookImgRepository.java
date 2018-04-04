package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

public interface BookImgRepository extends MongoRepository<BookImgAndDescrption, Integer> {

    public BookImgAndDescrption findByBookid(Integer bookid);
}
