package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 154910 on 2017-01-24.
 */
// spring 애플리케이션 컨텍스트 이용으로 변경
@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        /* DaoFactory 확정시 중복 코드 제거
        ConnectionMaker connectionMaker = new DConnectionMaker();*/
        ConnectionMaker connectionMaker = connectionMaker();
        UserDao dao = new UserDao(connectionMaker);
        return dao;
    }

    @Bean
    public ConnectionMaker connectionMaker()  {
        // connection 객체를 생성
        return new DConnectionMaker();
    }
}
