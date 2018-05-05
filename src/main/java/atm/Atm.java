package atm;

/**
 * Created by bender on 04.05.2018.
 */
public class Atm {
    private int balance;
    private int one, five, ten, fifty, oneHundred, fiveHundred, oneThousand;

    public Atm(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public Money getMoney(int amount) {
        if (amount <= 0 || amount > this.balance) {
            System.out.println("Not enough money");
            return null;
        }
        int thousands = 0, fiveHundreds = 0, oneHundreds = 0, fifties = 0, tens = 0, fives = 0, ones = 0;
        if (oneThousand > 0) {
            thousands = min(oneThousand, amount / 1000);
            oneThousand = oneThousand - thousands;
            amount = amount - 1000 * thousands;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (fiveHundred > 0) {
            fiveHundreds = min(fiveHundred, amount / 500);
            fiveHundred -= fiveHundreds;
            amount -= 500 * fiveHundreds;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (oneHundred > 0) {
            oneHundreds = min(oneHundred, amount / 100);
            oneHundred -= oneHundreds;
            amount -= 100 * oneHundreds;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (fifty > 0) {
            fifties = min(fifties, amount / 50);
            fifty -= fifties;
            amount -= fifties * 50;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (ten > 0) {
            tens = min(ten, amount / 10);
            ten -= tens;
            amount -= tens * 10;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (five > 0) {
            fives = min(five, amount / 5);
            five -= fives;
            amount -= fives * 5;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        if (one > 0) {
            ones = min(one, amount);
            one -= ones;
            amount -= ones;
            if (amount == 0) return new Money(thousands, fiveHundreds, oneHundreds, fifties, tens, fives, ones);
        }
        System.out.println("Unable to get the specified amount");
        return null;
    }

    public void takeMoney(Money money) {
        if (money != null) {
            this.balance += money.getAmount();
            this.one += money.getOnes();
            this.five += money.getFives();
            this.ten += money.getTens();
            this.oneHundred += money.getOneHundreds();
            this.fiveHundred += money.getFiveHundreds();
            this.oneThousand += money.getThousands();
        }
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getOneHundred() {
        return oneHundred;
    }

    public void setOneHundred(int oneHundred) {
        this.oneHundred = oneHundred;
    }

    public int getFiveHundred() {
        return fiveHundred;
    }

    public void setFiveHundreds(int fiveHundred) {
        this.fiveHundred = fiveHundred;
    }

    public int getOneThousand() {
        return oneThousand;
    }

    public void setOneThousand(int oneThousand) {
        this.oneThousand = oneThousand;
    }

}
