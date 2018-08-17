package my.education.webapplication.jdbc.dao;

import my.education.webapplication.jdbc.dataset.UserDataSet;

public interface UserDAO {
    void save(UserDataSet user);

    UserDataSet load(long id);
}
