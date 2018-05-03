package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.SaleRecord;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.pojo.User;
import xyz.veiasai.hibernate.receivejson.SearchBook;
import xyz.veiasai.hibernate.receivejson.SearchSaleRecord;
import xyz.veiasai.hibernate.result.BookResult;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.result.SaleRecordResult;
import xyz.veiasai.hibernate.result.UserResult;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.hibernate.service.SaleRecordService;
import xyz.veiasai.hibernate.service.UserService;
import xyz.veiasai.util.MyValidator;
import xyz.veiasai.util.groups.update;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {
    @Autowired
    private UserService userService;

    @Autowired
    private SaleRecordService saleRecordService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/postuser")
    @ResponseBody
    public Result updateUser(@RequestBody @Validated({update.class}) User user, BindingResult bindingResult) throws Exception {
        UserResult userResult = new UserResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userResult);
        }
        if (userService.update(user)) {
            userResult.setUser(user);
            userResult.setCode(200);
        } else {
            userResult.addMessage("this email doesn't exist");
            userResult.setCode(400);
        }
        return userResult;
    }

    @RequestMapping(value = "/deleteuser")
    @ResponseBody
    public Result deleteUser(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
        UserResult userResult = new UserResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, userResult);
        }

        if (userService.delete(user)) {
            userResult.setUser(user);
            userResult.setCode(200);
        } else {
            userResult.addMessage("this email doesn't exist");
            userResult.setCode(400);
        }
        return userResult;
    }

    @RequestMapping(value = "/getuser")
    @ResponseBody
    public Result getUser() throws Exception {
        UserResult userResult = new UserResult();
        userResult.setUsers(userService.findAll());
        userResult.setCode(200);
        return userResult;
    }

    @RequestMapping(value = "/getsalerecord")
    @ResponseBody
    public Result deleteUser(@RequestBody @Validated SearchSaleRecord searchSaleRecord, BindingResult bindingResult) throws Exception {
        SaleRecordResult saleRecordResult = new SaleRecordResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, saleRecordResult);
        }

        List<SaleRecord> list = saleRecordService.searchBooks(searchSaleRecord);
        saleRecordResult.setRecords(list);
        saleRecordResult.setCode(200);
        return saleRecordResult;
    }

    @RequestMapping(value = "/updatebook")
    @ResponseBody
    public Result BookPost(@RequestBody @Validated SingleBook singleBook, BindingResult bindingResult, HttpSession httpSession) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }
        if (bookService.update(singleBook))
        {
            bookResult.addMessage("update success");
            bookResult.setCode(200);
        }
        else {
            bookResult.addMessage("Invalid bookID");
            bookResult.setCode(400);
        }
        return bookResult;
    }

    @RequestMapping(value = "/deletebook")
    @ResponseBody
    public Result BookDelete(@RequestBody @Validated SingleBook singleBook, BindingResult bindingResult, HttpSession httpSession) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }

        if (bookService.delete(singleBook))
        {
            bookResult.addMessage("update success");
            bookResult.setCode(200);
        }
        else {
            bookResult.addMessage("Invalid bookID");
            bookResult.setCode(400);
        }
        return bookResult;
    }

    @RequestMapping(value = "/searchbooks")
    @ResponseBody
    public Result BookGET(@RequestBody @Valid SearchBook searchBook, HttpSession httpSession, BindingResult bindingResult) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }
        searchBook.setBookValid(null);
        bookResult.setBooks(bookService.searchBooks(searchBook));
        bookResult.addMessage("search success");
        bookResult.setCode(200);
        return bookResult;
    }
}
