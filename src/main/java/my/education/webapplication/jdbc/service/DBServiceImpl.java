package my.education.webapplication.jdbc.service;

import my.education.webapplication.jdbc.dao.UserDAO;
import my.education.webapplication.jdbc.dataset.UserDataSet;

/**
 * Created by bender on 11.08.2018.
 */
public class DBServiceImpl implements DBService {
    private final UserDAO userDAO;

    public DBServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(UserDataSet user) {
        userDAO.save(user);
    }

    @Override
    public UserDataSet loadById(long id) {
        return userDAO.load(id);
    }
}
