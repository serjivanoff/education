package atm_observer.department;

import java.util.Map;

/**
 * Created by bender on 17.06.2018.
 */
public interface AtmDepartment {
    void initReset();
    Map<String, Integer> initCollectingBalances();
}
