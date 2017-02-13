package springbook.user.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by 154910 on 2017-01-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext_home.xml")
public class UserDaoDataSourceTest {
    //@Autowired context에서 변수타입과 일치하는 빈을 찾아줌
    //private ApplicationContext context;
    @Autowired
    private UserDaoDataSource dao;
    private User user1;
    private User user2;
    private User user3;

    @Before // @Test 메소드가 실행되기 전에 실행됨
    public void setUp() {
        /* 스프링 테스트 컨테스트를 적용
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");*/
        /* dao 자체를 Autowired 로 설정
        this.dao = this.context.getBean("userDaoDataSource", UserDaoDataSource.class);*/
        this.user1 = new User("gyumee", "park.sc", "springno1");
        this.user2 = new User("leegw700", "lee.gw", "springno2");
        this.user3 = new User("bumjin", "park.bj", "springno3");

//        System.out.println("context : " + this.context);
//        System.out.println("this : " + this);
    }

    @Test
    public void count()  throws ClassNotFoundException, SQLException {
        /* @Before 메소드를 이용하여, 인스턴스 변수로 dao 변경
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDaoDataSource dao = context.getBean("userDaoDataSource", UserDaoDataSource.class);*/

        /* 테스트에 필요한 정보나 오브젝트(픽스처) @Before 메소드에서 생성
        User user1 = new User("gyumee", "park.sc", "springno1");
        User user2 = new User("leegw700", "lee.gw", "springno2");
        User user3 = new User("bumjin", "park.bj", "springno3");*/

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
        /* @Before 메소드를 이용하여, 인스턴스 변수로 dao 변경
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDaoDataSource dao = context.getBean("userDaoDataSource", UserDaoDataSource.class);*/

        dao.deleteAll();
        Assert.assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }


    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        /* @Before 메소드를 이용하여, 인스턴스 변수로 dao 변경
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDaoDataSource dao = context.getBean("userDaoDataSource", UserDaoDataSource.class);*/

        /* 테스트에 필요한 정보나 오브젝트(픽스처) @Before 메소드에서 생성
        User user1 = new User("gyumee", "park.sc", "springno1");
        User user2 = new User("leegw700", "lee.gw", "springno2");*/

        dao.deleteAll();
        Assert.assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        Assert.assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());
        Assert.assertThat(userget1.getName(), is(user1.getName()));
        Assert.assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());
        Assert.assertThat(userget2.getName(), is(user2.getName()));
        Assert.assertThat(userget2.getPassword(), is(user2.getPassword()));

        /* get 테스트 기능 보완
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);
        Assert.assertThat(dao.getCount(), is(1));

        User user2 = dao.get(user.getId());
        Assert.assertThat(user2.getName(), is(user.getName()));
        Assert.assertThat(user2.getPassword(), is(user.getPassword()));*/
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JUnitCore.main("springbook.user.dao.UserDaoDataSourceTest");

        // factory class 이용한 application context
        // ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceDaoFactory.class);
        // xml 이용한 application context
        /*ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDaoDataSource dao = context.getBean("userDaoDataSource", UserDaoDataSource.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("name : " + user2.getName());
        System.out.println("id : " + user2.getId() + " 조회 성공");*/
    }
}
