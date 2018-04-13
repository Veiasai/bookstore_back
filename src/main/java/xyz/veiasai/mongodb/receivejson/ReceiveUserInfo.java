package xyz.veiasai.mongodb.receivejson;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class ReceiveUserInfo {
    @NotEmpty(message = "image can'be empty")
    private String imageUrl;

    @NotEmpty(message = "type can'be empty")
    private String type;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
