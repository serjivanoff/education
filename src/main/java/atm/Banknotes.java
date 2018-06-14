package atm;

/**
 * Created by bender on 20.05.2018.
 */
public enum Banknotes{
    ONE(1), FIVE(5), TEN(10), FIFTY(50), ONE_HUNDRED(100), FIVE_HUNDREDS(500), ONE_THOUSAND(1000);
    private int value;
    Banknotes(int value){
        this.value = value;
    }

    public int value() {
        return value;
    }
}
