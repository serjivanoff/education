package my.education.jdbc.executor;

import my.education.jdbc.connection.ConnectionHelper;
import my.education.jdbc.dao.UserDAOImpl;
import my.education.jdbc.dao.executor.Executor;
import my.education.jdbc.dataset.UserDataSet;
import my.education.jdbc.service.DBService;
import my.education.jdbc.service.DBServiceImpl;
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
