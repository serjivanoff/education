package my.education.jdbc.executor;

import my.education.jdbc.connection.ConnectionHelper;
import my.education.jdbc.dao.UserDAO;
import my.education.jdbc.dao.UserDAOImpl;
import my.education.jdbc.dao.executor.Executor;
import my.education.jdbc.dataset.UserDataSet;
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