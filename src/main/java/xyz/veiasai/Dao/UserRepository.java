package xyz.veiasai.Dao;

import org.springframework.data.repository.Repository;
import xyz.veiasai.pojo.User;

public interface UserRepository extends Repository<User, Integer> {

    User findOne(Integer id);

    User save(User user);

    User findByEmail(String emailAddress);
}
