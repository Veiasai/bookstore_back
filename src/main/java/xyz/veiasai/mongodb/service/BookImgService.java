package xyz.veiasai.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.mongodb.dao.BookImgRepository;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

@Service
public class BookImgService {
    @Autowired
    BookImgRepository bookImgRepository;

    public boolean add(BookImgAndDescrption bookImgAndDescrption) {
        BookImgAndDescrption bookImgAndDescrption1temp = bookImgRepository.findByBookid(bookImgAndDescrption.getBookid());
        if (bookImgAndDescrption1temp != null)
            bookImgAndDescrption.setId(bookImgAndDescrption1temp.getId());
        bookImgRepository.save(bookImgAndDescrption);
        return true;
    }
}
