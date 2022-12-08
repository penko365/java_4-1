package by.pms;

public class User {
    private String nick;
    private String login;
    private String password;
    private String sex;
    private String lastVisit;
    private int messageCount;

    public User(String[] mas) {
        this.nick = mas[0];
        this.login = mas[1];
        this.password = mas[2];
        this.sex = mas[3];
        this.lastVisit = mas[4];
        this.messageCount = Integer.parseInt(mas[5]);
    }

    public String getNick() {
        return nick;
    }

    public String getElements() {
        return nick + " " +
                login + " " +
                password + " " +
                sex + " " +
                lastVisit + " " +
                messageCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "nick='" + nick + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", lastVisit=" + lastVisit +
                ", messageCount=" + messageCount +
                '}';
    }
}
