package xyz.veiasai.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.BookRepository;
import xyz.veiasai.hibernate.pojo.SingleBook;

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
        for (SingleBook singleBook : iterable)
        {
            list.add(singleBook);
        }
        return list;
    }

    public SingleBook findById(Integer id) {
        return bookRepository.findById(id).get();
    }
}


