package xyz.veiasai.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.veiasai.mongodb.pojo.Cart;
import xyz.veiasai.mongodb.service.CartService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cartpost")
    public String CartGet(@RequestBody @Valid Cart cart, HttpSession httpSession) throws Exception {
        Integer id = (Integer) httpSession.getAttribute("userID");
        if (id != null) //has logged in
        {
            cart.setId(id);
            cartService.add(cart);
        }
        return "";
    }
}
