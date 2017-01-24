package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * Created by 154910 on 2017-01-24.
 */
public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /* TEST 클래스에서 관계 생성 책임(client) 분리
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);*/
        /* spring 애플리케이션 컨텍스트 이용으로 변경
        UserDao dao = new DaoFactory().userDao();*/
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);
        UserDao dao2 = context.getBean("userDao", UserDao.class);

        System.out.println(dao);
        System.out.println(dao2);

        DaoFactory factory = new DaoFactory();
        UserDao dao3 = factory.userDao();
        UserDao dao4 = factory.userDao();

        System.out.println(dao3);
        System.out.println(dao4);

        /*User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getId() + "조회 성공");*/
    }
}
