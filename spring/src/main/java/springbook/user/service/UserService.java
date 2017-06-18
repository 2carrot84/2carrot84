package springbook.user.service;

import springbook.user.domain.User;

/**
 * Created by eguns on 2017. 6. 18..
 */
public interface UserService {
    void add(User user);
    void upgradeLevels();
}
