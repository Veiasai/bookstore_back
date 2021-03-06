package xyz.veiasai.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

@Document
public class Avatar implements Serializable {
    @Id
    @JsonIgnore
    private BigInteger id;

    @Indexed
    @JsonIgnore
    private Integer userID;

    private String avatar;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
