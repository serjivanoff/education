package my.education.webapplication.jdbc.executor;

import my.education.webapplication.jdbc.connection.ConnectionHelper;
import my.education.webapplication.jdbc.dao.UserDAO;
import my.education.webapplication.jdbc.dao.UserDAOImpl;
import my.education.webapplication.jdbc.dao.executor.Executor;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import org.junit.Assert;
import org.junit.Test;

//@Ignore
public class UserDAOTest {
    UserDAO userDAO = new UserDAOImpl(new Executor(ConnectionHelper.getConnection()));

    @Test
    public void saveAndLoadTest(){
        userDAO.save(TestData.USER_DATA_SET);
        UserDataSet fromDb = userDAO.load(14);
        Assert.assertEquals(TestData.USER_DATA_SET, fromDb);
    }
}