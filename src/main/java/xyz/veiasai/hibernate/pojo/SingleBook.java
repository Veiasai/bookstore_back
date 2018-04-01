package xyz.veiasai.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SingleBook {
    @Id
    private Integer bookID;

    @Column
    private String bookName;

    @Column
    private String bookprice;

}
