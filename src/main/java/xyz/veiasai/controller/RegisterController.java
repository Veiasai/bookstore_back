package xyz.veiasai.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.veiasai.pojo.Test;
import xyz.veiasai.pojo.User;
import xyz.veiasai.service.DeptDaoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

@Controller
public class RegisterController {
    private User user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Test register(@RequestBody Test user) throws Exception {

        return user;
    }
}
