package xyz.veiasai.mongodb.service;

import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;

public interface BookImgService {
    boolean add(BookImgAndDescrption bookImgAndDescrption);

    BookImgAndDescrption findbyBookid(Integer bookid);
}
