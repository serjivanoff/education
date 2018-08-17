package my.education.webapplication.jdbc.hibernate;

import my.education.webapplication.jdbc.dao.hibernate.HibernateUserDaoImpl;
import my.education.webapplication.jdbc.dataset.UserDataSet;
import my.education.webapplication.jdbc.service.DBService;
import my.education.webapplication.jdbc.service.DBServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import static my.education.webapplication.jdbc.executor.TestData.userDataSet;


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
