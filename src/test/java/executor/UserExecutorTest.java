package executor;

import jdbc.executor.UserExecutor;
import jdbc.executor.UserExecutorImpl;
import jdbc.executor.dataset.UserDataSet;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class UserExecutorTest {
    UserExecutor userExecutor = new UserExecutorImpl();
    @Test
    public void saveAndLoadTest(){
//        userExecutor.save(TestData.TEST_USERDATASET);
        UserDataSet fromDb = userExecutor.load(1);
        Assert.assertEquals(TestData.TEST_USERDATASET, fromDb);
    }
}