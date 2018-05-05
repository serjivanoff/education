package atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * Created by bender on 04.05.2018.
 */
public class AtmTest {
    private Atm atm;
    private final int BALANCE = 2500,
            THOUSAND = 1, FIVEHUNDRED = 1,
            ONEHUNDRED = 3, FIFTY = 3, TEN = 5,
            FIVE = 5, ONE = 10;
    private Money money;

    @Before
    public void init() {
        this.atm = new Atm(BALANCE);
        atm.setOneThousand(1);
        atm.setFiveHundreds(1);
        atm.setOneHundred(3);
        atm.setFifty(3);
        atm.setTen(5);
        atm.setFive(5);
        atm.setOne(10);
        this.money = new Money(1, 1, 1, 0, 1, 0, 3);
    }

    @Test
    public void getBalanceTest() {
        Assert.assertTrue(atm.getBalance() == BALANCE);
    }

    @Test
    public void takeMoneyTest() {
        atm.takeMoney(money);
        Assert.assertTrue(atm.getOne() == ONE + money.getOnes());
        Assert.assertTrue(atm.getFive() == FIVE + money.getFives());
        Assert.assertTrue(atm.getTen() == TEN + money.getTens());
        Assert.assertTrue(atm.getFifty() == FIFTY + money.getFifties());
        Assert.assertTrue(atm.getOneHundred() == ONEHUNDRED + money.getOneHundreds());
        Assert.assertTrue(atm.getFiveHundred() == FIVEHUNDRED + money.getFiveHundreds());
        Assert.assertTrue(atm.getOneThousand() == THOUSAND + money.getThousands());
        Assert.assertTrue(atm.getBalance() == BALANCE + money.getAmount());
    }

    @Test
    public void getAmountTest() {
        Money byAtm = atm.getMoney(1613);
        Assert.assertTrue(byAtm.equals(money));
        Assert.assertTrue(atm.getOneThousand() == THOUSAND - byAtm.getThousands());
        Assert.assertTrue(atm.getFiveHundred() == FIVEHUNDRED - byAtm.getFiveHundreds());
        Assert.assertTrue(atm.getOneHundred() == ONEHUNDRED - byAtm.getOneHundreds());
        Assert.assertTrue(atm.getFifty() == FIFTY - byAtm.getFifties());
        Assert.assertTrue(atm.getTen() == TEN - byAtm.getTens());
        Assert.assertTrue(atm.getFive() == FIVE - byAtm.getFives());
        Assert.assertTrue(atm.getOne() == ONE - byAtm.getOnes());
    }
}
