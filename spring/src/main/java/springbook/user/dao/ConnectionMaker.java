package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 154910 on 2017-01-24.
 */
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
