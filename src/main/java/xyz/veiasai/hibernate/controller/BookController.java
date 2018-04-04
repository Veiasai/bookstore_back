package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.mask.ReceiveBook;
import xyz.veiasai.hibernate.mask.SearchBook;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.server.BookResult;
import xyz.veiasai.hibernate.server.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;
import xyz.veiasai.mongodb.service.BookImgService;
import xyz.veiasai.util.MyValidator;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookImgService bookImgService;

    @RequestMapping(value = "/postbook")
    @ResponseBody
    public Result BookPost(@RequestBody ReceiveBook receiveBook, BindingResult bindingResult) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }
        SingleBook singleBook = receiveBook.getSingleBook();
        BookImgAndDescrption bookImgAndDescrption = receiveBook.getBookImgAndDescrption();

        singleBook.setBookID(null);
        singleBook.setValid(false);
        singleBook.setBookStock(100);
        bookService.add(singleBook);
        bookImgAndDescrption.setBookid(singleBook.getBookID());
        System.out.println(singleBook.getBookID());
        bookImgService.add(bookImgAndDescrption);

        bookResult.addMessage("upload success");
        bookResult.setCode(200);
        return bookResult;
    }

    @RequestMapping(value = "/searchbooks")
    @ResponseBody
    public Result BookGET(@RequestBody SearchBook searchBook, BindingResult bindingResult) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }

        bookResult.setBooks(bookService.searchAll());
        bookResult.addMessage("search success");
        bookResult.setCode(200);
        return bookResult;
    }
}
