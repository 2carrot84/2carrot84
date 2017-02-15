package springbook.user.dao.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 154910 on 2017-02-15.
 */
public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection c)  throws SQLException;
}
