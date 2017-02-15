package springbook.user.dao.jdbccontext;

import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.dao.template.DeleteAllStatement;
import springbook.user.dao.template.StatementStrategy;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 154910 on 2017-01-24.
 */
public class UserDaoJdbcContext {

    private JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    // 클라이언트
    public void deleteAll() throws ClassNotFoundException, SQLException {
        StatementStrategy starategy = new DeleteAllStatement(); // 전략 오브젝트 생성
        jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("delete from users");
                return ps;
            }
        });   // 컨텍스트 호출, 전략 오브젝트 전달
    }

    public int getCount() throws ClassNotFoundException//, SQLException
    {
        return 0;
    }

    // 클라이언트
    public void add(final User user) throws ClassNotFoundException, SQLException {
        jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            // 개별적인 전략
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");

                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());

                return ps;
            }
        });
    }

    public User get(String id) throws ClassNotFoundException, SQLException {


        return null;
    }
}
