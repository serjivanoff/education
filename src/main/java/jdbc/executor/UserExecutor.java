package jdbc.executor;

import jdbc.executor.dataset.UserDataSet;

public interface UserExecutor {
    void save(UserDataSet user);

    UserDataSet load(long id);
}
