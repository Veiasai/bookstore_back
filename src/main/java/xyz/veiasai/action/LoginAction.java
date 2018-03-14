package xyz.veiasai.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import xyz.veiasai.Dao.DeptDao;
import xyz.veiasai.pojo.*;
import javax.servlet.http.HttpServletRequest;


public class LoginAction extends ActionSupport{
    private User user;
    private DeptDao deptDao;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() throws Exception{

        HttpServletRequest request = ServletActionContext.getRequest();
        user = new User();
        user.setUsername(request.getParameter("username"));
        return "success";
    }
}