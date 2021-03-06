package my.education.atm_observer;

import my.education.atm_mememto_iterator.Banknotes;
import my.education.atm_observer.department.AtmDepartment;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static my.education.atm_mememto_iterator.Banknotes.*;
import static java.util.Comparator.reverseOrder;

public class AtmImpl implements Atm {
    private String name;
    private AtmDepartment department;

    private Map<Banknotes, Integer> state;

    public AtmImpl(String name) {
        this.name = name;
    }

    public AtmImpl(String name, Map<Banknotes, Integer> state) {
        this.state = state;
        this.name = name;
    }

    public int calculate(Map<Banknotes, Integer> state) {
        return state.keySet().stream().mapToInt(b -> b.value() * state.get(b)).sum();
    }

    public TreeMap<Banknotes, Integer> getMoney(int amount) {
        if (amount > getBalance() || amount < 0) {
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

    public Map<Banknotes, Integer> getState() {
        return state;
    }

    public void setState(Map<Banknotes, Integer> state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AtmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(AtmDepartment department) {
        this.department = department;
    }

    @Override
    public void resetState() {
        Map<Banknotes, Integer> state = new TreeMap<>(reverseOrder());
        state.put(ONE, 10);
        state.put(FIVE, 10);
        state.put(TEN, 10);
        state.put(FIFTY, 10);
        state.put(ONE_HUNDRED, 10);
        state.put(FIVE_HUNDREDS, 5);
        state.put(ONE_THOUSAND, 2);
        this.state = state;
    }

    @Override
    public int getBalance() {
            return state.keySet().stream().mapToInt(b -> b.value() * state.get(b)).sum();
    }
}
