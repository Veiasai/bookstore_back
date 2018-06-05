package xyz.veiasai.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.mongodb.dao.AvatarRepository;
import xyz.veiasai.mongodb.dao.BookCoverRepository;
import xyz.veiasai.mongodb.dao.CartRepository;
import xyz.veiasai.mongodb.pojo.Avatar;
import xyz.veiasai.mongodb.pojo.BookCover;
import xyz.veiasai.mongodb.pojo.Cart;
import xyz.veiasai.mongodb.result.UserInfoResult;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private BookCoverRepository bookCoverRepository;

    @Override
    public void saveAvatar(Integer userID, Avatar avatar) {
        Avatar temp = avatarRepository.findByUserID(userID);
        if (temp != null)
            avatar.setId(temp.getId());
        avatarRepository.save(avatar);

    }

    @Override
    public void saveCover(Integer userID, BookCover bookCover) {
        BookCover temp = bookCoverRepository.findByUserID(userID);
        if (temp != null)
            bookCover.setId(temp.getId());
        bookCoverRepository.save(bookCover);
    }

    @Override
    public Avatar getAvatar(Integer userID)
    {
        return avatarRepository.findByUserID(userID);
    }

    @Override
    public BookCover getBookCover(Integer userID)
    {
        return bookCoverRepository.findByUserID(userID);
    }
}
