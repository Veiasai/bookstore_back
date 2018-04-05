package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.mask.ReceiveBook;
import xyz.veiasai.hibernate.mask.SearchBook;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.result.BookResult;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;
import xyz.veiasai.mongodb.service.BookImgService;
import xyz.veiasai.util.MyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookImgService bookImgService;

    @RequestMapping(value = "/postbook")
    @ResponseBody
    public Result BookPost(@RequestBody @Valid  ReceiveBook receiveBook, BindingResult bindingResult) throws Exception {
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
    public Result BookGET(@RequestBody @Valid SearchBook searchBook, BindingResult bindingResult) throws Exception {
        BookResult bookResult = new BookResult();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, bookResult);
        }

        bookResult.setBooks(bookService.searchAll());
        bookResult.addMessage("search success");
        bookResult.setCode(200);
        return bookResult;
    }

    @RequestMapping(value = "/getbook/{bookID}")
    @ResponseBody
    public Result BookGET(@PathVariable Integer bookID) throws Exception {
        BookResult bookResult = new BookResult();
        if (bookID == null)
        {
            bookResult.addMessage("need bookID");
            bookResult.setCode(400);
        }

        SingleBook temp1 = bookService.findById(bookID);
        BookImgAndDescrption temp2 = bookImgService.findbyBookid(bookID);
        if (temp2 == null || temp1 == null)
        {
            bookResult.addMessage("not found");
            bookResult.setCode(400);
            return bookResult;
        }
        bookResult.setSingleBook(temp1);
        bookResult.setBookImgAndDescrption(temp2);
        bookResult.addMessage("found book");
        bookResult.setCode(200);
        return bookResult;
    }

    @RequestMapping(value = "/postbookimg")
    public void BookImgPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    }
}
