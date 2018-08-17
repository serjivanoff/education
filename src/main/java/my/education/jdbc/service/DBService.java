package my.education.jdbc.service;

import my.education.jdbc.dataset.UserDataSet;

/**
 * Created by bender on 11.08.2018.
 */
public interface DBService {
    void save(UserDataSet user);

    UserDataSet loadById(long id);
}
