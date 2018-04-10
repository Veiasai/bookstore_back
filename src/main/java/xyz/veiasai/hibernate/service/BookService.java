package xyz.veiasai.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.BookRepository;
import xyz.veiasai.hibernate.mask.SingleCommodity;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean add(SingleBook singleBook) {
        if (bookRepository.findByBookID(singleBook.getBookID()) == null) {
            bookRepository.save(singleBook);
            return true;
        }
        return false;
    }

    public List<SingleBook> searchAll() {
        Iterable<SingleBook> iterable = bookRepository.findAll();
        List<SingleBook> list = new ArrayList<SingleBook>();
        for (SingleBook singleBook : iterable) {
            list.add(singleBook);
        }
        return list;
    }

    public SingleBook findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public List<Commodity> generateOrder(List<SingleCommodity> rebooks, Order order) throws Exception {
        List<Commodity> books = new ArrayList<Commodity>();
        Integer total = 0;
        for (SingleCommodity sc : rebooks) {
            SingleBook singleBook = findById(sc.getBookID());
            if (singleBook == null)
                throw new Exception("不存在的书籍");
            else if (singleBook.getBookStock() < sc.getBookCount())
                throw new Exception("库存不足");

            books.add(new Commodity(singleBook, sc.getBookCount()));
            singleBook.setBookStock(singleBook.getBookStock() - sc.getBookCount());
            bookRepository.save(singleBook);
            total += singleBook.getBookPrice() * sc.getBookCount();
        }
        order.setTotalPrice(total);
        order.setBooks(books);
        return books;
    }
}


