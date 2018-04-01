package xyz.veiasai.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.mongodb.dao.CartRepository;
import xyz.veiasai.mongodb.pojo.Cart;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public boolean add(Cart cart) {
        Cart oldcart = cartRepository.findByIndex(cart.getIndex());
        if (oldcart != null)
            cart.setId(oldcart.getId());
        cartRepository.save(cart);
        return true;
    }
}
