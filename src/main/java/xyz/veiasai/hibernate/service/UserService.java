package xyz.veiasai.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.UserRepository;
import xyz.veiasai.hibernate.pojo.User;

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

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
