package springbook.user.dao.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import springbook.user.domain.Level;
import springbook.user.domain.User;

/**
 * Created by 154910 on 2017-01-24.
 */
public class UserDao {

	private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private RowMapper<User> rowmapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rownum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setLevel(Level.valueOf(rs.getInt("level")));
            user.setLogin(rs.getInt("login"));
            user.setRecommend(rs.getInt("recommend"));
			return user;
		}
	}; 

    public void deleteAll() {
    	this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
    	SqlRowSet rs = this.jdbcTemplate.queryForRowSet("select count(*) from users");
    	rs.next();
    	return rs.getInt(1);
    }

    public void add(final User user) {
    	this.jdbcTemplate.update("insert into users(id, name, password, level, login, recommend) values(?, ?, ?, ?, ?, ?)",
    			user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend());
    }

    public User get(String id) {
    	return this.jdbcTemplate.queryForObject("select * from users where id = ?",
    			new Object[] {id},
    			rowmapper);
    }
    
    public List<User> getAll() {
    	return this.jdbcTemplate.query("select * from users order by id", rowmapper);
    }

	public void update(User user) {
    	this.jdbcTemplate.update("update users set name = ?, password = ?, level = ?, login = ?, recommend = ? " +
				"where id = ?", user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getId());
	}
}
