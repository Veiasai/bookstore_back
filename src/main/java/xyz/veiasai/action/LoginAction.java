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
        if (session.getAttribute("email") != null)
            return "success";
        this.username = request.getParameter("email");
        session.setAttribute("email",this.username);
        return "success";
    }
}