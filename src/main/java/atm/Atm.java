package atm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Atm {
    private Map<Banknotes, Integer> state;

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
        TreeMap<Banknotes, Integer> result = new TreeMap<>(Comparator.reverseOrder());
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
}
