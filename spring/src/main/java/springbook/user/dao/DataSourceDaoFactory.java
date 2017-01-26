package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by 154910 on 2017-01-24.
 */
// spring 애플리케이션 컨텍스트 이용으로 변경
@Configuration
public class DataSourceDaoFactory {
    @Bean
    public UserDaoDataSource userDao() {
        UserDaoDataSource dao = new UserDaoDataSource();
        dao.setDataSource(dataSource());
        return dao;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@174.100.29.31:1521:BOONS");
        dataSource.setUsername("wsemart");
        dataSource.setPassword("newshin");

        return dataSource;
    }
}
