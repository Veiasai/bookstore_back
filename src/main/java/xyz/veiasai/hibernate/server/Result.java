package xyz.veiasai.hibernate.server;

public interface Result {
    Integer getTimeID();

    void setTimeID(Integer timeID);

    Integer getCode();

    void setCode(Integer code);

    void addMessage(String in);
}
