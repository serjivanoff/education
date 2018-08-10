package jdbc.executor;

import jdbc.connection.ConnectionHelper;
import jdbc.executor.dataset.UserDataSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExecutorImpl implements UserExecutor {
    private final Connection connection;

    public UserExecutorImpl() {
        connection = ConnectionHelper.getConnection();
    }


    @Override
    public void save(UserDataSet user) {
        String query = "INSERT INTO users (name, age) VALUES (?,?)";
        try (PreparedStatement stmnt = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            stmnt.setString(1, user.getName());
            stmnt.setInt(2, user.getAge());
            stmnt.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public UserDataSet load(long id) {
        UserDataSet result = null;
        String query = "SELECT * FROM users WHERE id =(?)";
        try (PreparedStatement stmnt = connection.prepareStatement(query)) {
            stmnt.setLong(1, id);
            ResultSet rs = stmnt.executeQuery();
            if (rs.next()) {
                result = new UserDataSet(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
