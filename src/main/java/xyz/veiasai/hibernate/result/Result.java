package xyz.veiasai.hibernate.result;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> message;
    private Integer timeID;
    private Integer code;

    public Integer getTimeID() {
        return timeID;
    }

    public void setTimeID(Integer timeID) {
        this.timeID = timeID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void addMessage(String in) {
        if (message == null)
        {
            message = new ArrayList<String>();
        }
        message.add(in);
    }
}
