package my.education.atm_mememto_iterator;

import java.util.Map;

/**
 * Created by bender on 17.06.2018.
 */
public class State {
    private final Map<Banknotes,Integer> state;

    public State(Map<Banknotes, Integer> state) {
        this.state = state;
    }

    public Map<Banknotes, Integer> getState() {
        return state;
    }
}
