package xyz.veiasai.hibernate.Dao;

import org.springframework.data.repository.CrudRepository;
import xyz.veiasai.hibernate.pojo.SingleBook;

public interface BookRepository extends CrudRepository<SingleBook, Integer> {

    SingleBook findByBookID(Integer bookid);
}
