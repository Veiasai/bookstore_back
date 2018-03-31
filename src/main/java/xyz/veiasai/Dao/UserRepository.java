package xyz.veiasai.Dao;

import org.springframework.data.repository.CrudRepository;

import xyz.veiasai.pojo.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
