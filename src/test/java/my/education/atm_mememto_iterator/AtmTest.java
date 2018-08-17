package my.education.atm_mememto_iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class AtmTest {
    private Atm atm;
    public static final int INITIAL_AMOUNT = 6160;

    @Before
    public void init() {
        this.atm = new Atm();
        this.atm.setState(atm.save().getState());
    }

    @Test
    public void getReserveTest() {
        Assert.assertEquals(atm.getReserve(), INITIAL_AMOUNT);
    }

    @Test
    public void getMoneyTest() {
        Map<Banknotes, Integer> money = atm.getMoney(2713);
        Assert.assertEquals(atm.calculate(money), 2713);
        Assert.assertEquals(atm.getReserve(), 6160 - 2713);
    }

    @Test
    public void notEnoughMoneyTest() {
        Assert.assertNull(atm.getMoney(atm.getReserve() + 1));
    }

    @Test
    public void canNotGiveSuchAmount() {
        atm.getMoney(4);
        atm.getMoney(4);
        Assert.assertEquals(atm.getReserve(), INITIAL_AMOUNT - 8);
        Assert.assertNull(atm.getMoney(4));
        Assert.assertEquals(atm.getReserve(), INITIAL_AMOUNT - 8);
    }
}
