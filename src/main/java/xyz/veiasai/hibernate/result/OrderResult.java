package xyz.veiasai.hibernate.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.pojo.BookImgAndDescrption;
import xyz.veiasai.mongodb.pojo.Order;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class OrderResult extends Result {

    private  Order order;

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
