package xyz.veiasai.pojo;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class LoginUser {

    @NotNull(message = "password can't be null")
    private String password;

    @NotNull(message = "email can't be null")
    @Email(message = "invalid email")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
