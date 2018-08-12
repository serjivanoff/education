package jdbc.dao.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bender on 11.08.2018.
 */
public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execQuery(String query, ResultHandler handler) {
        try (PreparedStatement stmnt = connection.prepareStatement(query)) {
            stmnt.execute();
            ResultSet rs = stmnt.getResultSet();
            if (rs != null) handler.handle(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
