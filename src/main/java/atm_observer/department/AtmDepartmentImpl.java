package atm_observer.department;


import atm_observer.Atm;
import atm_observer.AtmImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by bender on 20.05.2018.
 */
public class AtmDepartmentImpl implements AtmDepartment {
    private List<AtmImpl> atms;

    public AtmDepartmentImpl(int size) {
        atms = new ArrayList<>(size);
        for(int i = 0; i<size; i++){
            atms.add(new AtmImpl("Name"+i));
        }
        initReset();
    }

    @Override
    public void initReset() {
        atms.forEach(Atm::resetState);
    }

    @Override
    public Map<String, Integer> initCollectingBalances() {
        return atms.stream().collect(Collectors.toMap(AtmImpl::getName, AtmImpl::getBalance));
    }

    public List<AtmImpl> getAtms() {
        return atms;
    }
}
