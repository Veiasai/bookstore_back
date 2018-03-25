package xyz.veiasai.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import xyz.veiasai.pojo.User;
import xyz.veiasai.service.DeptDaoService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

public class RegisterAction extends ActionSupport {
    private User user;
    private DeptDaoService deptDaoService;
    private ValidatorFactory validatorFactory;
    private String errorMessage;
    private Iterator<ConstraintViolation<User>> itr;

    public Iterator<ConstraintViolation<User>> getItr() {
        return itr;
    }

    public void setItr(Iterator<ConstraintViolation<User>> itr) {
        this.itr = itr;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
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

    public String register() throws Exception{
        Validator validator = validatorFactory.getValidator();
        HttpServletRequest request = ServletActionContext.getRequest();
        user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setValid(true);
        user.setLevel(0);
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate( user );
        if (constraintViolations.size() > 0)
        {
            errorMessage =  constraintViolations.iterator().next().getMessage();
            itr = constraintViolations.iterator();
            return "input";
        }
        deptDaoService.add(user);
        return "success";
    }
}
