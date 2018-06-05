package xyz.veiasai.mongodb.service;

import xyz.veiasai.mongodb.pojo.Cart;

public interface CartService {
    boolean add(Cart cart);

    Cart get(Integer userid);
}
