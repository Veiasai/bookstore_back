package xyz.veiasai.hibernate.Dao;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import xyz.veiasai.hibernate.pojo.User;

public interface UserRepository extends CrudRepository<User, Integer>, QuerydslPredicateExecutor<User>{

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
