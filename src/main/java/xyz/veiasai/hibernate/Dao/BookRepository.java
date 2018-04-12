package xyz.veiasai.hibernate.Dao;

import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.repository.CrudRepository;
import xyz.veiasai.hibernate.pojo.SingleBook;

import java.util.List;

public interface BookRepository extends CrudRepository<SingleBook, Integer> {

    SingleBook findByBookID(Integer bookid);

    List<SingleBook> findAllByValid(boolean valid);

}
