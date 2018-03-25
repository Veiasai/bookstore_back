package xyz.veiasai.pojo;


import javax.validation.constraints.*;

public class User {
    @NotNull(message="username can't be null")
    private String username;
    @Pattern(regexp = "(^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$)",message = "password must have both digits and alpha(size:6-18)")
    private String password;
    private String email;
    private Boolean valid;
    private Integer level;
    private Integer id;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
