package xyz.veiasai.hibernate.service;

import xyz.veiasai.hibernate.pojo.User;

import java.util.List;

public interface UserService {
    boolean add(User user);

    boolean update(User user);

    boolean delete(User user);

    List<User> findAll();

    User login(String email, String password);

    User findById(Integer id);
}
