package xyz.veiasai.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.mongodb.dao.OrderRepository;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public boolean add(Order order) {
        orderRepository.save(order);
        return true;
    }

    public List<Order> findUserOrders(Integer userID) {
        return orderRepository.findAllByIndex(userID);
    }
}
