package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, BigInteger>{

    public Order findByIndex(Integer index);

    public List<Order> findAllByIndex(Integer index);

}
