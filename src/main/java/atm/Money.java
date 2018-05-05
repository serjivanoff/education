package atm;

/**
 * Created by bender on 05.05.2018.
 */
public class Money {
    private int amount, ones, fives, tens, fifties, oneHundreds, fiveHundreds, thousands;

    public Money(int thousands, int fiveHundreds, int oneHundreds, int fifties, int tens, int fives, int ones) {
        this.ones = ones;
        this.fives = fives;
        this.tens = tens;
        this.fifties = fifties;
        this.oneHundreds = oneHundreds;
        this.fiveHundreds = fiveHundreds;
        this.thousands = thousands;
        this.amount = thousands*1000 + fiveHundreds*500 + oneHundreds*100 + fifties*50 + tens*10 + fives*5 + ones;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public int getTens() {
        return tens;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getOneHundreds() {
        return oneHundreds;
    }

    public void setOneHundreds(int oneHundreds) {
        this.oneHundreds = oneHundreds;
    }

    public int getFiveHundreds() {
        return fiveHundreds;
    }

    public void setFiveHundreds(int fiveHundreds) {
        this.fiveHundreds = fiveHundreds;
    }

    public int getThousands() {
        return thousands;
    }

    public void setThousands(int thousands) {
        this.thousands = thousands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (ones != money.ones) return false;
        if (fives != money.fives) return false;
        if (tens != money.tens) return false;
        if (fifties != money.fifties) return false;
        if (oneHundreds != money.oneHundreds) return false;
        if (fiveHundreds != money.fiveHundreds) return false;
        return thousands == money.thousands;
    }

    @Override
    public int hashCode() {
        int result = ones;
        result = 31 * result + fives;
        result = 31 * result + tens;
        result = 31 * result + fifties;
        result = 31 * result + oneHundreds;
        result = 31 * result + fiveHundreds;
        result = 31 * result + thousands;
        return result;
    }
}
