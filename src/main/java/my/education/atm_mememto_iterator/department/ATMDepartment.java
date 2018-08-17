package my.education.atm_mememto_iterator.department;

import my.education.atm_mememto_iterator.Atm;
import my.education.atm_mememto_iterator.AtmCollection;
import my.education.atm_mememto_iterator.AtmIterator;

/**
 * Created by bender on 20.05.2018.
 */
public class ATMDepartment implements AtmCollection {
    private Atm[] atms;

    public ATMDepartment(int size) {
        atms = new Atm[size];
        for (int i = 0; i < size; i++)
            atms[i] = new Atm();
        resetAtms();
    }

    public void resetAtms() {
        AtmIterator atmIterator = new AtmIteratorImpl();
        while (atmIterator.hasNext()) {
            Atm atm = atmIterator.next();
            atm.load(atm.save());
        }
    }

    public int[] getBalances() {
        int[] result = new int[atms.length];
        int i = 0;
        AtmIterator atmIterator = new AtmIteratorImpl();
        while (atmIterator.hasNext()) {
            Atm atm = atmIterator.next();
            result[i++] = atm.getReserve();
        }
        return result;
    }

    @Override
    public AtmIterator iterator() {
        return new AtmIteratorImpl();
    }

    public Atm[] getAtms() {
        return atms;
    }

    public Atm getByIndex(int index) {
        return (index >= atms.length || index < 0) ? null : atms[index];
    }

    private class AtmIteratorImpl implements AtmIterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < atms.length;
        }

        @Override
        public Atm next() {
            return atms[index++];
        }
    }
}
