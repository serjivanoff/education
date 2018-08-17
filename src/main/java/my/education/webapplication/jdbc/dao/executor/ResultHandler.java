package my.education.webapplication.jdbc.dao.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bender on 11.08.2018.
 */
public interface ResultHandler {
    void handle(ResultSet resultSet) throws SQLException;
}
