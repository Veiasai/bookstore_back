package xyz.veiasai.hibernate.service;

import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.receivejson.SearchBook;
import xyz.veiasai.mongodb.pojo.Order;
import xyz.veiasai.mongodb.receivejson.ReceiveCommodity;

import java.util.List;

public interface BookService {
    boolean add(SingleBook singleBook);

    boolean delete(SingleBook singleBook);

    boolean update(SingleBook singleBook);

    List<SingleBook> searchAll();

    List<SingleBook> searchBooks(SearchBook searchBook);

    SingleBook findById(Integer id);

    void generateOrder(List<ReceiveCommodity> rebooks, Order order) throws Exception;
}
