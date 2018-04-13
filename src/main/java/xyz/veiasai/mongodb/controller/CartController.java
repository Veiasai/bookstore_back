package xyz.veiasai.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.result.CartResult;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.Cart;
import xyz.veiasai.mongodb.service.CartService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/postcart")
    @ResponseBody
    public Result CartPost(@RequestBody Cart cart, HttpSession httpSession) throws Exception {
        CartResult cartResult = new CartResult();
        Integer id = (Integer) httpSession.getAttribute("userID");
        cart.setIndex(id);
        cartService.add(cart);
        cartResult.addMessage("update cart success");
        cartResult.setCode(200);
        return cartResult;
    }

    @RequestMapping(value = "/getcart")
    @ResponseBody
    public Result Cartget(HttpSession httpSession) throws Exception {
        CartResult cartResult = new CartResult();
        Integer id = (Integer) httpSession.getAttribute("userID");
        Cart cart = cartService.get(id);
        if (cart != null) {
            List<Integer> bookIDs = cart.getBookIDs();
            for (Integer i : bookIDs) {
                SingleBook singleBook = bookService.findById(i);
                if (singleBook != null && singleBook.getValid())
                {
                    cartResult.addBook(singleBook);
                }
            }

            cartResult.addMessage("get success");
            cartResult.setCode(200);
        }
        else{
            cartResult.addMessage("empty cart");
            cartResult.setCode(400);
        }
        return cartResult;
    }
}
