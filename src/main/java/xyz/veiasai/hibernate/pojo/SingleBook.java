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
    private Integer bookPrice;

    @Column
    private String bookWriter;

    @Column
    private String bookDate;

    @Column
    private String bookClass;
}
