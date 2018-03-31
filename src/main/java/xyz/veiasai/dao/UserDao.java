package xyz.veiasai.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.veiasai.pojo.User;

@Repository
public class UserDao {
    // Spring与Hibernate整合： IOC容器注入
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 保存一个记录
    // Spring与Hibernate整合：事务管理交给Spring
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
