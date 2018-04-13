package xyz.veiasai.hibernate.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.BookRepository;
import xyz.veiasai.hibernate.pojo.QSingleBook;
import xyz.veiasai.mongodb.receivejson.ReceiveCommodity;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.receivejson.SearchBook;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;


import java.util.ArrayList;
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

    public List<SingleBook> searchBooks(SearchBook searchBook, Boolean valid) {
        QSingleBook qSingleBook = QSingleBook.singleBook;
        BooleanExpression all = qSingleBook.valid.eq(valid);
        if (searchBook.getDateRange() != null) {
            all = all.and(qSingleBook.bookDate.between(searchBook.getDateRange().get(0), searchBook.getDateRange().get(1)));
        }
        if (searchBook.getSearchText() != null){
            all = all.and(qSingleBook.bookName.contains(searchBook.getSearchText()).or(qSingleBook.bookWriter.contains(searchBook.getSearchText())));
        }
        if (searchBook.getPriceRange() != null)
        {
            all = all.and(qSingleBook.bookPrice.between(searchBook.getPriceRange().get(0), searchBook.getPriceRange().get(1)));
        }
        if (searchBook.getBookClass() != null)
        {
            all = all.and(qSingleBook.bookClass.eq(searchBook.getBookClass()));
        }
        Iterable<SingleBook> iterable = bookRepository.findAll(all);
        List<SingleBook> list = new ArrayList<SingleBook>();
        for (SingleBook singleBook : iterable) {
            list.add(singleBook);
        }
        return list;
    }

    public List<SingleBook> searchValid(boolean valid) {
        return bookRepository.findAllByValid(valid);
    }

    public SingleBook findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public List<Commodity> generateOrder(List<ReceiveCommodity> rebooks, Order order) throws Exception {
        List<Commodity> books = new ArrayList<Commodity>();
        Integer total = 0;
        for (ReceiveCommodity sc : rebooks) {
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


