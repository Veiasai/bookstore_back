package xyz.veiasai.server;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import xyz.veiasai.pojo.LoginUser;
import xyz.veiasai.pojo.User;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LoginResult {
    private User user;
    private List<String> message = new ArrayList();
    private Integer timeID;
    private Integer code;

    public Integer getTimeID() {
        return timeID;
    }

    public void setTimeID(Integer timeID) {
        this.timeID = timeID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void addMessage(String in) {
        message.add(in);
    }
}
