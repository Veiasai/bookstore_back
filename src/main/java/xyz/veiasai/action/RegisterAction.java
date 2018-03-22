package xyz.veiasai.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import xyz.veiasai.pojo.User;
import xyz.veiasai.service.DeptDaoService;

import javax.servlet.http.HttpServletRequest;

public class RegisterAction extends ActionSupport {
    private User user;
    private DeptDaoService deptDaoService;

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
        HttpServletRequest request = ServletActionContext.getRequest();
        user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setValid(true);
        user.setLevel(0);
        deptDaoService.add(user);
        return "success";
    }
}
