package xyz.veiasai.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.Avatar;
import xyz.veiasai.mongodb.pojo.BookCover;
import xyz.veiasai.mongodb.pojo.Cart;
import xyz.veiasai.mongodb.receivejson.ReceiveUserInfo;
import xyz.veiasai.mongodb.result.CartResult;
import xyz.veiasai.mongodb.result.UserInfoResult;
import xyz.veiasai.mongodb.service.CartService;
import xyz.veiasai.mongodb.service.UserInfoService;
import xyz.veiasai.util.MyValidator;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/postuser")
    @ResponseBody
    public Result UserInfoPost(@RequestBody ReceiveUserInfo receiveUserInfo, BindingResult bindingResult, HttpSession httpSession) throws Exception {
        UserInfoResult userInfoResult = new UserInfoResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userInfoResult);
        }

        Integer id = (Integer) httpSession.getAttribute("userID");
        if (receiveUserInfo.getType().equals("Avatar"))
        {
            Avatar avatar = new Avatar();
            avatar.setUserID(id);
            avatar.setAvatar(receiveUserInfo.getImageUrl());
            userInfoService.saveAvatar(id, avatar);
            userInfoResult.setAvatar(avatar.getAvatar());
        }
        else if (receiveUserInfo.getType().equals("Cover"))
        {
            BookCover bookCover = new BookCover();
            bookCover.setUserID(id);
            bookCover.setCover(receiveUserInfo.getImageUrl());
            userInfoService.saveCover(id, bookCover);
            userInfoResult.setFavoriteBook(bookCover.getCover());
        }

        userInfoResult.setCode(200);
        return userInfoResult;
    }

    @RequestMapping(value = "/getuser")
    @ResponseBody
    public Result UserInfoGET(HttpSession httpSession) throws Exception {
        UserInfoResult userInfoResult = new UserInfoResult();
        Integer id = (Integer) httpSession.getAttribute("userID");
        Avatar avatar = userInfoService.getAvatar(id);
        BookCover bookCover = userInfoService.getBookCover(id);
        if (avatar != null){
            userInfoResult.setAvatar(avatar.getAvatar());
        }
        if (bookCover != null) {
            userInfoResult.setFavoriteBook(bookCover.getCover());
        }
        userInfoResult.setCode(200);
        return userInfoResult;
    }
}
