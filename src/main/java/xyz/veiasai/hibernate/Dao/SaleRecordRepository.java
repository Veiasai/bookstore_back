package xyz.veiasai.hibernate.Dao;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import xyz.veiasai.hibernate.pojo.SaleRecord;
import xyz.veiasai.hibernate.pojo.SingleBook;

import java.util.List;

public interface SaleRecordRepository extends CrudRepository<SaleRecord, Integer>, QuerydslPredicateExecutor<SaleRecord> {

}
