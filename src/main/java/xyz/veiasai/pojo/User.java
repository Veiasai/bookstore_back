package xyz.veiasai.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @Column
    @NotNull(message="username can't be null")
    @Pattern(regexp="(^$|.{6,20})",message = "username size should be 6-20")
    private String username;

    @Column
    @NotNull(message="password can't be null")
    @Pattern(regexp = "(^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$)",message = "password must have both digits and alpha(size:6-18)")
    private String password;

    @Column(unique = true)
    @NotNull(message="email can't be null")
    @Email(message = "invalid email")
    private String email;

    @JsonIgnore
    @Column
    private Boolean valid;

    @JsonIgnore
    @Column
    private Integer level;

    @JsonIgnore
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
