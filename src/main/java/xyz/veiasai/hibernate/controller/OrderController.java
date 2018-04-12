package xyz.veiasai.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.hibernate.receivejson.ReceiveOrder;
import xyz.veiasai.hibernate.result.OrderResult;
import xyz.veiasai.hibernate.result.Result;
import xyz.veiasai.hibernate.service.BookService;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;
import xyz.veiasai.mongodb.service.OrderService;
import xyz.veiasai.util.MyValidator;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/postorder")
    @ResponseBody
    public Result OrderPost(@RequestBody @Validated ReceiveOrder receiveOrder, BindingResult bindingResult, HttpSession session) throws Exception {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return MyValidator.notMatched(bindingResult, result);
        }
        Order order = new Order();
        try {
            List<Commodity> commodities = bookService.generateOrder(receiveOrder.getBooks(), order);
        } catch (Exception e) {
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

    @RequestMapping(value = "/getorder")
    @ResponseBody
    public Result OrderGet(HttpSession session) throws Exception {
        OrderResult orderResult = new OrderResult();
        orderResult.setOrders(orderService.findUserOrders((Integer) session.getAttribute("userID")));
        orderResult.setCode(200);
        return orderResult;
    }

    @RequestMapping(value = "/getorder/{id}")
    @ResponseBody
    public Result OrderGetOne(@PathVariable BigInteger id, HttpSession session) throws Exception {
        OrderResult orderResult = new OrderResult();
        Order order = orderService.findById(id);
        if (order == null) {
            orderResult.addMessage("Not Found");
            orderResult.setCode(400);
        } else if (order.getUserID() != (Integer) session.getAttribute("userID")) {
            orderResult.addMessage("Forbidden");
            orderResult.setCode(400);
        } else {
            orderResult.setOrder(order);
            orderResult.setCode(200);
        }
        return orderResult;
    }
}
