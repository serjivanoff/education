package jdbc.dao;

import jdbc.dataset.UserDataSet;

public interface UserDAO {
    void save(UserDataSet user);

    UserDataSet load(long id);
}
