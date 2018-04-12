package xyz.veiasai.hibernate.query;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;
import xyz.veiasai.hibernate.pojo.SingleBook;

import javax.annotation.Nullable;

public class Qbook extends EntityPathBase<SingleBook> {
    public Qbook(Class<? extends SingleBook> type, String variable) {
        super(type, variable);
    }

    public Qbook(Class<? extends SingleBook> type, PathMetadata metadata) {
        super(type, metadata);
    }

    public Qbook(Class<? extends SingleBook> type, PathMetadata metadata, @Nullable PathInits inits) {
        super(type, metadata, inits);
    }


}
