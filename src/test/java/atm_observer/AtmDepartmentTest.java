package atm_observer;

import atm_observer.department.AtmDepartmentImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static atm_mememto_iterator.AtmTest.INITIAL_AMOUNT;

/**
 * Created by bender on 17.06.2018.
 */
public class AtmDepartmentTest {
    private AtmDepartmentImpl atmDepartment;

    @Before
    public void init() {
        this.atmDepartment = new AtmDepartmentImpl(10);
    }

    @Test
    public void getStatesAfterCreationTest() {
        atmDepartment.getAtms().forEach(a -> Assert.assertEquals(a.getBalance(), INITIAL_AMOUNT));
    }

    @Test
    public void initResetStateTest() {
        atmDepartment.getAtms().forEach(a -> {
            a.getMoney(1687);
            Assert.assertEquals(a.getBalance(), INITIAL_AMOUNT - 1687);
        });
        atmDepartment.initReset();
        atmDepartment.getAtms().forEach(a -> Assert.assertEquals(a.getBalance(), INITIAL_AMOUNT));
    }

    @Test
    public void initGetBalances() {
        Map<String, Integer> balances = atmDepartment.initCollectingBalances();
        int[] i = new int[]{0};
        balances.entrySet().forEach(e ->
                Assert.assertTrue(balances.containsKey("Name" + i[0]++) && e.getValue() == INITIAL_AMOUNT));
    }
}
