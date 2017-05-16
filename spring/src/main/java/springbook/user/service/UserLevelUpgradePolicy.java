package springbook.user.service;

import springbook.user.domain.User;

/**
 * Created by eguns on 2017. 5. 16..
 */
public interface UserLevelUpgradePolicy {
    boolean canUpdatedLevel(User user);
    void upgradeLevel(User user);
}
