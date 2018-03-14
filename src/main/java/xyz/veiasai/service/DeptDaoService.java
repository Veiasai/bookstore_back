package xyz.veiasai.service;

import xyz.veiasai.Dao.DeptDao;
import xyz.veiasai.pojo.User;

public class DeptDaoService {
    private DeptDao deptDao;

    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public void add(User user) {
        deptDao.add(user);
    }
}
