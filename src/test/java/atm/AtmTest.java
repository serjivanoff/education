package atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static atm.Banknotes.*;

/**
 * Created by bender on 04.05.2018.
 */
public class AtmTest {
    private Atm atm;
    private final int INITIAL_AMOUNT = 6160;

    @Before
    public void init() {
        TreeMap<Banknotes, Integer> state = new TreeMap<>(Comparator.reverseOrder());
        state.put(ONE, 10);
        state.put(FIVE, 10);
        state.put(TEN, 10);
        state.put(FIFTY, 10);
        state.put(ONE_HUNDRED, 10);
        state.put(FIVE_HUNDREDS, 5);
        state.put(ONE_THOUSAND, 2);
        this.atm = new Atm(state);
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
