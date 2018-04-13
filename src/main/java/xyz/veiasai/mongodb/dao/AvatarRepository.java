package xyz.veiasai.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.veiasai.mongodb.pojo.Avatar;
import xyz.veiasai.mongodb.pojo.Cart;

import java.math.BigInteger;

public interface AvatarRepository extends MongoRepository<Avatar, BigInteger>{
    public Avatar findByUserID(Integer userID);
}
