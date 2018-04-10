package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.veiasai.mongodb.pojo.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

    public Order findByIndex(Integer index);

}
