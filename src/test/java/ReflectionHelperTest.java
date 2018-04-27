import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ReflectionHelper;


public class ReflectionHelperTest {
    @Before
    public void init1(){
    }
    @Before
    public void init2(){}
    @Test
    public void createInstanceTest() {
        User user = new User("Name", 444);
        User reflected = ReflectionHelper.createInstance(User.class, "Name", 444);
        Assert.assertTrue(user.getAge() == reflected.getAge());
        Assert.assertEquals(user.getName(), reflected.getName());
    }


}
