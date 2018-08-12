package jdbc.hibernate;

import jdbc.dao.hibernate.HibernateUserDaoImpl;
import jdbc.dataset.UserDataSet;
import jdbc.service.DBService;
import jdbc.service.DBServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import static jdbc.executor.TestData.userDataSet;


/**
 * Created by bender on 11.08.2018.
 */
public class HibernateDBServiceTest {
    private final DBService service = new DBServiceImpl(new HibernateUserDaoImpl());
    @Test
    public void saveTest(){
        service.save(userDataSet);
    }

    @Test
    public void loadByIdTest(){
        UserDataSet user = service.loadById(1);
        Assert.assertEquals(userDataSet, user);
    }
}
