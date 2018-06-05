package xyz.veiasai.hibernate.service;

import xyz.veiasai.hibernate.pojo.SaleRecord;
import xyz.veiasai.hibernate.receivejson.SearchSaleRecord;
import xyz.veiasai.mongodb.pojo.Order;

import java.util.List;

public interface SaleRecordService {
    void add(SaleRecord saleRecord);

    List<SaleRecord> searchBooks(SearchSaleRecord searchSaleRecord);

    void record(Order order);
}
