package jdbc.dao;

import jdbc.dao.executor.Executor;
import jdbc.dataset.UserDataSet;

public class UserDAOImpl implements UserDAO {
    private final Executor executor;

    public UserDAOImpl(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void save(UserDataSet user) {
        String insert = "INSERT INTO users (name, age) VALUES ('%s',%s)";
        executor.execQuery(String.format(insert, user.getName(), user.getAge()),
                resultSet -> {
                    resultSet.next();
                    System.out.printf("saved user with id=%s", resultSet.getLong(0));
                });
    }

    @Override
    public UserDataSet load(long id) {
        UserDataSet[] result = new UserDataSet[]{null};
        String select = "SELECT * FROM users WHERE id =%s";
        executor.execQuery(String.format(select, id), rs -> {
            rs.next();
            result[0] = new UserDataSet(id, rs.getString("name"), rs.getInt("age"), null, null);
            System.out.printf("Loaded user: %s", result[0].toString());
        });
        return result[0];
    }

}
