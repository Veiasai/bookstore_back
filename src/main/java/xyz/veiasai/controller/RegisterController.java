package xyz.veiasai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.Dao.DeptDao;
import xyz.veiasai.pojo.User;
import xyz.veiasai.service.DeptDaoService;

@Controller
public class RegisterController {

    @Autowired
    private DeptDaoService deptDaoService;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DeptDaoService getDeptDaoService() {
        return deptDaoService;
    }

    public void setDeptDaoService(DeptDaoService deptDaoService) {
        this.deptDaoService = deptDaoService;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public User register(@RequestBody User user) throws Exception {
        user.setValid(true);
        user.setLevel(0);
        deptDaoService.add(user);
        return user;
    }
}
