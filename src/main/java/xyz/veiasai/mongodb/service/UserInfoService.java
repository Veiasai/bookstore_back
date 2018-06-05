package xyz.veiasai.mongodb.service;

import xyz.veiasai.mongodb.pojo.Avatar;
import xyz.veiasai.mongodb.pojo.BookCover;

public interface UserInfoService {
    void saveAvatar(Integer userID, Avatar avatar);

    void saveCover(Integer userID, BookCover bookCover);

    Avatar getAvatar(Integer userID);

    BookCover getBookCover(Integer userID);
}
