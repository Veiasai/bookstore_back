package xyz.veiasai.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import xyz.veiasai.Dao.DeptDao;
import xyz.veiasai.pojo.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginAction extends ActionSupport{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        this.username = request.getParameter("username");
        session.setAttribute("username",this.username);
        return "success";
    }
}