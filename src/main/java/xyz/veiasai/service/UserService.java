package xyz.veiasai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.Dao.UserRepository;
import xyz.veiasai.pojo.User;

import javax.annotation.Resource;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean add(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null)
        {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
