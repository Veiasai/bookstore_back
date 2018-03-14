package xyz.veiasai.Dao;

import org.hibernate.SessionFactory;
import xyz.veiasai.pojo.User;

public class DeptDao {
    // Spring与Hibernate整合： IOC容器注入
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
