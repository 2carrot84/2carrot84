package springbook.user.dao.aop;

import springbook.user.domain.User;

import java.util.List;

/**
 * Created by eguns on 2017. 6. 18..
 */
public interface UserDao {
    void deleteAll();
    int getCount();
    void add(final User user);
    User get(String id);
    List<User> getAll();
    void update(User user);
}
