package springbook.user.dao.jdbcTemplate;

import static org.hamcrest.CoreMatchers.is;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.domain.Level;
import springbook.user.domain.User;

/**
 * Created by 154910 on 2017-01-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_home.xml")
public class UserDaoTest {
    @Autowired
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before // @Test 메소드가 실행되기 전에 실행됨
    public void setUp() {
        this.user1 = new User("gyumee", "park.sc", "springno1", Level.BASIC, 1, 0);
        this.user2 = new User("leegw700", "lee.gw", "springno2", Level.SILVER, 55, 10);
        this.user3 = new User("bumjin", "park.bj", "springno3", Level.GOLD, 100, 40);
    }

    @Test
    public void getAll() {
    	dao.deleteAll();
    	
    	dao.add(user1);
    	List<User> users1 = dao.getAll();
    	Assert.assertThat(users1.size(), is(1));
    	checkSameUser(user1, users1.get(0));
    	
    	dao.add(user2);
    	List<User> users2 = dao.getAll();
    	Assert.assertThat(users2.size(), is(2));
    	checkSameUser(user1, users2.get(0));
    	checkSameUser(user2, users2.get(1));
    	
    	dao.add(user3);
    	List<User> users3 = dao.getAll();
    	Assert.assertThat(users3.size(), is(3));
    	checkSameUser(user3, users3.get(0));
    	checkSameUser(user1, users3.get(1));
    	checkSameUser(user2, users3.get(2));
    }
    
    private void checkSameUser(User user1, User user2) {
    	Assert.assertThat(user1.getId(), is(user2.getId()));
    	Assert.assertThat(user1.getName(), is(user2.getName()));
        Assert.assertThat(user1.getPassword(), is(user2.getPassword()));
        Assert.assertThat(user1.getLevel(), is(user2.getLevel()));
        Assert.assertThat(user1.getLogin(), is(user2.getLogin()));
        Assert.assertThat(user1.getRecommend(), is(user2.getRecommend()));
    }
    
    @Test
    public void count()  throws ClassNotFoundException, SQLException {
        dao.deleteAll();
        Assert.assertThat(dao.getCount(), is(0));

        dao.add(user1);
        Assert.assertThat(dao.getCount(), is(1));
        dao.add(user2);
        Assert.assertThat(dao.getCount(), is(2));
        dao.add(user3);
        Assert.assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        Assert.assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        dao.deleteAll();
        Assert.assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        Assert.assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        checkSameUser(userget1, user1);

        User userget2 = dao.get(user2.getId());
        checkSameUser(userget2, user2);
    }

    @Test
    public void update() {
        dao.deleteAll();

        dao.add(user1);
        dao.add(user2);

        user1.setName("oh.mk");
        user1.setPassword("springno6");
        user1.setLevel(Level.GOLD);
        user1.setLogin(1000);
        user1.setRecommend(999);
        dao.update(user1);

        User user1update = dao.get(user1.getId());
        checkSameUser(user1, user1update);
        User user2update = dao.get(user2.getId());
        checkSameUser(user2, user2update);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JUnitCore.main("springbook.user.dao.jdbcTemplate.UserDaoTest");
    }
}
