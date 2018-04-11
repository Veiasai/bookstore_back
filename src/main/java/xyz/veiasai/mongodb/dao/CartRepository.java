package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.Cart;

import java.math.BigInteger;

public interface CartRepository extends MongoRepository<Cart, BigInteger>{
    public Cart findByIndex(Integer index);
}
