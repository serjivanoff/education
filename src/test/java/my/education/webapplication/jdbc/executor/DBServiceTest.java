package my.education.webapplication.jdbc.executor;

import my.education.webapplication.jdbc.connection.ConnectionHelper;
import my.education.webapplication.jdbc.dao.UserDAOImpl;
import my.education.webapplication.jdbc.dao.executor.Executor;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.jdbc.service.DBService;
import my.education.webapplication.jdbc.service.DBServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by bender on 11.08.2018.
 */
public class DBServiceTest {
    private final DBService service = new DBServiceImpl(new UserDAOImpl(new Executor(ConnectionHelper.getConnection())));

    @Test
    public void serviceSaveTest() {
        service.save(TestData.USER_DATA_SET);
    }

    @Test
    public void serviceLoadByIdTest() {
        UserDataSet fromDb = service.loadById(15);
        Assert.assertEquals(TestData.USER_DATA_SET, fromDb);
    }
}
