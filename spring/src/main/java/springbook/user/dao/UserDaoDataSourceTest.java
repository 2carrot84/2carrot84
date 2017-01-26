package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * Created by 154910 on 2017-01-24.
 */
public class UserDaoDataSourceTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // factory class 이용한 application context
        // ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceDaoFactory.class);
        // xml 이용한 application context
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDaoDataSource dao = context.getBean("userDaoDataSource", UserDaoDataSource.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("name : " + user2.getName());
        System.out.println("id : " + user2.getId() + " 조회 성공");
    }
}
