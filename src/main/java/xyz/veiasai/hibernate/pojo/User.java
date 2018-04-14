package xyz.veiasai.hibernate.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import xyz.veiasai.util.groups.delete;
import xyz.veiasai.util.groups.update;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Column
    @NotNull(message = "username can't be null")
    @Pattern(regexp = "(^$|.{6,20})", message = "username size should be 6-20")
    @NotNull(message = "username can't be null", groups = {update.class})
    @Pattern(regexp = "(^$|.{6,20})", message = "username size should be 6-20", groups = {update.class})
    private String username;

    @Column
    @NotNull(message = "password can't be null")
    @Pattern(regexp = "(^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$)", message = "password must have both digits and alpha(size:6-18)")
    @NotNull(message = "password can't be null", groups = {update.class})
    @Pattern(regexp = "(^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$)", message = "password must have both digits and alpha(size:6-18)", groups = {update.class})
    private String password;

    @Column(unique = true)
    @NotNull(message = "email can't be null")
    @Email(message = "invalid email")
    @NotNull(message = "email can't be null", groups = {update.class})
    @Email(message = "invalid email", groups = {update.class})
    private String email;

    @Column
    @NotNull(message = "valid can't be null", groups = {update.class})
    private Boolean valid;

    @Column
    @NotNull(message = "level can't be null", groups = {update.class})
    private Integer level;

    @NotNull(message = "level can't be null", groups = {update.class})
    @NotNull(message = "level can't be null", groups = {delete.class})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setId(Integer id) {
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
