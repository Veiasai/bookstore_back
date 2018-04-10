package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.mask.ReceiveBook;
import xyz.veiasai.hibernate.mask.ReceiveOrder;
import xyz.veiasai.hibernate.mask.SearchBook;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.result.BookResult;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;
import xyz.veiasai.mongodb.service.BookImgService;
import xyz.veiasai.mongodb.service.OrderService;
import xyz.veiasai.util.MyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/postorder")
    @ResponseBody
    public Result BookPost(@RequestBody @Validated ReceiveOrder receiveOrder, BindingResult bindingResult, HttpSession session) throws Exception {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, result);
        }
        Order order = new Order();
        try {
            List<Commodity> commodities = bookService.generateOrder(receiveOrder.getBooks(), order);
        }
        catch (Exception e){
            result.addMessage(e.toString());
            result.setCode(400);
        }
        order.setUserID((Integer) session.getAttribute("userID"));
        order.setDate(receiveOrder.getDate());
        order.setIndex(order.getUserID());
        orderService.add(order);
        result.setCode(200);
        return result;
    }

}
