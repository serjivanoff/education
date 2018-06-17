package atm_mememto_iterator;

import java.util.*;

import static atm_mememto_iterator.Banknotes.*;
import static java.util.Comparator.reverseOrder;

public class Atm implements AtmCollection{
    private Map<Banknotes, Integer> state;

    public Atm() {
    }

    public Atm(Map<Banknotes, Integer> state) {
        this.state = state;
    }

    public int getReserve() {
        return state.keySet().stream().mapToInt(b -> b.value() * state.get(b)).sum();
    }

    public int calculate(Map<Banknotes, Integer> state) {
        return state.keySet().stream().mapToInt(b -> b.value() * state.get(b)).sum();
    }

    public TreeMap<Banknotes, Integer> getMoney(int amount) {
        if (amount > getReserve() || amount < 0) {
            System.out.println("Invalid request!");
            return null;
        }
        TreeMap<Banknotes, Integer> result = new TreeMap<>(reverseOrder());
        Iterator<Banknotes> iterator = state.keySet().iterator();
        while (iterator.hasNext() && amount > 0) {
            Banknotes banknote = iterator.next();
            int value = banknote.value(), quantity = amount / value, available = state.get(banknote);
            if (available > 0 && quantity > 0) {
                if (quantity <= available) {
                    result.put(banknote, quantity);
                    state.put(banknote, available - quantity);
                    amount -= quantity * value;
                } else {
                    result.put(banknote, available);
                    state.put(banknote, 0);
                    amount -= available * value;
                }
            }
        }
        if (amount > 0) {
            System.out.println("Can't take service for that sum, try another, please");
            result.keySet().forEach(b -> state.put(b, b.value() * result.get(b) + state.get(b)));
           return null;
        }
        return result;
    }
    public State save(){
        Map<Banknotes, Integer> state = new TreeMap<>(reverseOrder());
        state.put(ONE, 10);
        state.put(FIVE, 10);
        state.put(TEN, 10);
        state.put(FIFTY, 10);
        state.put(ONE_HUNDRED, 10);
        state.put(FIVE_HUNDREDS, 5);
        state.put(ONE_THOUSAND, 2);
        return new State(state);
    }

    public void load(State state){
        this.state = state.getState();
    }

    public Map<Banknotes, Integer> getState() {
        return state;
    }

    public void setState(Map<Banknotes, Integer> state) {
        this.state = state;
    }

    @Override
    public AtmIterator iterator() {
        return null;
    }
}
