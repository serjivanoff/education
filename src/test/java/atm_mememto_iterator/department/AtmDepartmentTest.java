package atm_mememto_iterator.department;

import atm_mememto_iterator.Atm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static atm_mememto_iterator.AtmTest.INITIAL_AMOUNT;

/**
 * Created by bender on 17.06.2018.
 */
public class AtmDepartmentTest {

    private ATMDepartment department;

    @Before
    public void init() {
        this.department = new ATMDepartment(10);
    }

    @Test
    public void reseStatesTest() {
        for (int i = 0; i < department.getAtms().length; i++) {
            Atm current = department.getByIndex(i);
            current.getMoney(1567);
            Assert.assertEquals(current.getReserve(), INITIAL_AMOUNT - 1567);
        }
        department.resetAtms();
        for(int i = 0; i<department.getAtms().length; i++){
            Assert.assertEquals(department.getByIndex(i).getReserve(), INITIAL_AMOUNT);
        }
    }
}
