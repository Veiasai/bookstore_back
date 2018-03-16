package xyz.veiasai.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import xyz.veiasai.action.LoginAction;

import java.util.Map;


public class UserInterceptor implements Interceptor {
    public void init(){
    }

    public void destroy(){
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        Object action = invocation.getAction();
        if (action instanceof LoginAction) {
            System.out.println("exit check login, because this is login action.");
            return invocation.invoke();
        }

        Map session = invocation.getInvocationContext().getSession();
        String login = (String) session.get("username");
        if (login != null && login.length() > 0) {
            return invocation.invoke();
        } else {
            return "login";
        }
    }
}
