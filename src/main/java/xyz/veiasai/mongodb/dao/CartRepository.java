package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer>{

}
