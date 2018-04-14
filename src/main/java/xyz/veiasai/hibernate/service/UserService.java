package xyz.veiasai.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.UserRepository;
import xyz.veiasai.hibernate.pojo.QUser;
import xyz.veiasai.hibernate.pojo.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean add(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean update(User user) {
        QUser qUser = QUser.user;
        if (userRepository.exists(qUser.id.eq(user.getId()))) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean delete(User user) {
        User oldUser = userRepository.findByEmail(user.getEmail());
        if ( oldUser != null) {
            userRepository.delete(oldUser);
            return true;
        }
        return false;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        for (User item : userRepository.findAll())
        {
            users.add(item);
        }
        return users;
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
