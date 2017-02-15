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
        jdbcContextWithStatementsStrategy(starategy);   // 컨텍스트 호출, 전략 오브젝트 전달
        /*
        3장 예외처리 전 소스
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("delete from users");
        ps.executeUpdate();

        ps.close();
        c.close();*/

        /*
        예외처리 적용 후
        jdbc관련 컨텍스트를 분리
        jdbcContextWithStatementsStrategy 메소드 분리

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();
            // 변하는 부분
            //ps = c.prepareStatement("delete from users");
            //ps = makeStatement(c);

            // 변하는 부분을 전략(interface)로 분리하여, interface를 통해 deleteAll전략을 받아 실행
            StatementStrategy starategy = new DeleteAllStatement();
            ps = starategy.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
//            throw e;
            e.printStackTrace();
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    public int getCount() throws ClassNotFoundException//, SQLException
    {
        /*
        3장 예외처리 전 소스
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from users");
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();
        */
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("select count(*) from users");
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
//            throw e;
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return count;
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
        /*
        3장 예외처리 소스 전
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        *//* 쿼리 결과가 없을 경우 exception 발생
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));*//*

        User user = null;

        if(rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if(user == null) throw new EmptyResultDataAccessException(1);

        return user;*/

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            c = dataSource.getConnection();
            ps = c.prepareStatement("select * from users where id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
//            throw e;
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if(user == null) throw new EmptyResultDataAccessException(1);

        return user;
    }
}
