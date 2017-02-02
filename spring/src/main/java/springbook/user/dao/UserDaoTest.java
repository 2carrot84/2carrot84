package springbook.user.dao;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by 154910 on 2017-01-24.
 */
public class UserDaoTest {

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.delete(user.getId());

        dao.add(user);

        User user2 = dao.get(user.getId());

//        Assert.assertThat(user2.getName(), is(user.getName()));
        Assert.assertThat(user2.getPassword(), is(user.getPassword()));
    }


    protected static void main(String[] args) throws ClassNotFoundException, SQLException {
        /* TEST 클래스에서 관계 생성 책임(client) 분리
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);*/
        /* spring 애플리케이션 컨텍스트 이용으로 변경
        UserDao dao = new DaoFactory().userDao();*/
        // class bean 사용
        //ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        /** test 소스를 jUnit으로 변환
        // xml bean 설정 사용
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

         * application context 이용한 객체 생성과 new 를 이용한 객체 생성의 차이 비교
         * application Context 를 이용할 경우 싱글톤 형태로 객체 생성(하나의 객체만 생성 후 동일한 객체 리턴)
         UserDao dao2 = context.getBean("userDao", UserDao.class);

        System.out.println(dao);
        System.out.println(dao2);

        DaoFactory factory = new DaoFactory();
        UserDao dao3 = factory.userDao();
        UserDao dao4 = factory.userDao();

        System.out.println(dao3);
        System.out.println(dao4);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("name : " + user2.getName());
        System.out.println("id : " + user2.getId() + " 조회 성공");
         */

        JUnitCore.main("springbook.user.dao.UserDaoTest");
    }
}
