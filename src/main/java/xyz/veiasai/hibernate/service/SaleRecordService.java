package xyz.veiasai.hibernate.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.veiasai.hibernate.Dao.SaleRecordRepository;
import xyz.veiasai.hibernate.pojo.QSaleRecord;
import xyz.veiasai.hibernate.pojo.SaleRecord;
import xyz.veiasai.hibernate.pojo.SingleBook;
import xyz.veiasai.hibernate.receivejson.SearchSaleRecord;
import xyz.veiasai.mongodb.pojo.Commodity;
import xyz.veiasai.mongodb.pojo.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleRecordService {

    @Autowired
    private SaleRecordRepository saleRecordRepository;

    public void add(SaleRecord saleRecord) {
        saleRecordRepository.save(saleRecord);
    }

    public List<SaleRecord> searchBooks(SearchSaleRecord searchSaleRecord) {
        QSaleRecord qSaleRecord = QSaleRecord.saleRecord;
        BooleanExpression all = qSaleRecord.isNotNull();
        if (searchSaleRecord.getBookClass() != null)
        {
            all = all.and(qSaleRecord.bookClass.eq(searchSaleRecord.getBookClass()));
        }
        if (searchSaleRecord.getBookWriter() != null)
        {
            all = all.and(qSaleRecord.bookWriter.contains(searchSaleRecord.getBookWriter()));
        }
        if (searchSaleRecord.getDateRange() != null)
        {
            all = all.and(qSaleRecord.date.between(searchSaleRecord.getDateRange().get(0),searchSaleRecord.getDateRange().get(1)));
        }
        if (searchSaleRecord.getUserID() != null)
        {
            all = all.and(qSaleRecord.userID.eq(searchSaleRecord.getUserID()));
        }
        if (searchSaleRecord.getBookID() != null)
        {
            all = all.and(qSaleRecord.bookID.eq(searchSaleRecord.getBookID()));
        }
        Iterable<SaleRecord> iterable = saleRecordRepository.findAll(all);
        List<SaleRecord> list = new ArrayList<SaleRecord>();
        for (SaleRecord saleRecord : iterable) {
            list.add(saleRecord);
        }
        return list;
    }

    public void record(Order order){
        List<Commodity> list = order.getBooks();
        SaleRecord saleRecord = new SaleRecord();
        saleRecord.setDate(order.getDate());
        saleRecord.setUserID(order.getUserID());
        for (Commodity item : list){
            saleRecord.setID(null);
            saleRecord.setBookClass(item.getBookClass());
            saleRecord.setBookCount(item.getBookCount());
            saleRecord.setBookID(item.getBookID());
            saleRecord.setBookName(item.getBookName());
            saleRecord.setBookPrice(item.getBookPrice());
            saleRecord.setBookWriter(item.getBookWriter());
            saleRecordRepository.save(saleRecord);
        }
    }

}


