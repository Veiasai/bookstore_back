package xyz.veiasai.mongodb.service;

import xyz.veiasai.mongodb.pojo.Order;
import xyz.veiasai.mongodb.receivejson.SearchOrder;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {
    boolean add(Order order);

    Order findById(BigInteger id);

    List<Order> searchOrders(SearchOrder searchOrder, Integer userID);
}
