package jdbc.executor;

import jdbc.connection.ConnectionHelper;
import jdbc.dao.UserDAO;
import jdbc.dao.UserDAOImpl;
import jdbc.dao.executor.Executor;
import jdbc.dataset.UserDataSet;
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