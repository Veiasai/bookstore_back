package xyz.veiasai.mongodb.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.mongodb.dao.OrderRepository;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;
import xyz.veiasai.mongodb.pojo.QOrder;
import xyz.veiasai.mongodb.receivejson.SearchOrder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public boolean add(Order order) {
        orderRepository.save(order);
        return true;
    }

    public Order findById(BigInteger id) {
        return orderRepository.findById(id).get();
    }

    public List<Order> searchOrders(SearchOrder searchOrder, Integer userID) {
        QOrder qOrder = QOrder.order;
        BooleanExpression all = qOrder.userID.eq(userID);
        if (searchOrder.getDateRange() != null)
        {
            all = all.and( qOrder.date.between(searchOrder.getDateRange().get(0),searchOrder.getDateRange().get(1)));
        }
        if (searchOrder.getSearchText() != null)
        {
            all = all.and( qOrder.books.any().bookName.contains(searchOrder.getSearchText()).or(qOrder.books.any().bookWriter.contains(searchOrder.getSearchText())));
        }
        List<Order> list = new ArrayList<Order>();
        for (Order order : orderRepository.findAll(all)) {
            list.add(order);
        }
        return list;
    }
}
