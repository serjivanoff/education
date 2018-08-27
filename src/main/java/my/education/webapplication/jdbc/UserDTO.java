package my.education.webapplication.jdbc;

/**
 * Created by bender on 26.08.2018.
 */
public class UserDTO {
    private final String login;
    private final String password;

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
