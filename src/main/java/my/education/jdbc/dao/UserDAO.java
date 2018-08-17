package my.education.jdbc.dao;

import my.education.jdbc.dataset.UserDataSet;

public interface UserDAO {
    void save(UserDataSet user);

    UserDataSet load(long id);
}
