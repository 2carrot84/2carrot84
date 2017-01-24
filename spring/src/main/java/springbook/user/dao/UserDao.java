package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

/**
 * Created by 154910 on 2017-01-24.
 */
/* 상속을 통한 확장
public class UserDao {*/
//public abstract class UserDao {
public class UserDao {
    // interface 사용하여 connection 관심 분리
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        /* 중복 코드의 메소드 추출
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@174.100.29.31:1521:BOONS", "wsemart", "newshin");*/
        /* connection 관심사 분리
        Connection c = getConnection();*/
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();;
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        /* 중복 코드의 메소드 추출
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@174.100.29.31:1521:BOONS", "wsemart", "newshin");*/
        /* connection 관심사 분리
        Connection c = getConnection();*/
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
    /* 상속을 통한 확장
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@174.100.29.31:1521:BOONS", "wsemart", "newshin");
        return c;
    }*/
    /* connection 객체 분리 후 interface로 생성자에서 주입
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException ;*/

    /* TEST 관심 UserDaoTest 클래스로 분리
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new NUserDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getId() + "조회 성공");
    }*/
}
