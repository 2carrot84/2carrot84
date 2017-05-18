package springbook.user.service;

import springbook.user.dao.jdbcTemplate.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

/**
 * Created by eguns on 2017. 5. 16..
 */
public class UserService implements UserLevelUpgradePolicy {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMEND_FOR_GOLD = 30;

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            if(canUpdatedLevel(user)) {
                upgradeLevel(user);
            }
            /*
            코드 개선전
            Boolean changed = null;
            if(user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
                user.setLevel(Level.SILVER);
                changed = true;
            }
            else if(user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
                user.setLevel(Level.GOLD);
                changed = true;
            }
            else if(user.getLevel() == Level.GOLD) {
                changed = false;
            }
            else {
                changed = false;
            }

            if(changed) {
                userDao.update(user);
            }*/
        }
    }

    @Override
    public boolean canUpdatedLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("Unknown Level : " + currentLevel); // 예외
        }
    }

    @Override
    public void upgradeLevel(User user) {
        /*if(user.getLevel() == Level.BASIC) user.setLevel(Level.SILVER);
        else if(user.getLevel() == Level.SILVER) user.setLevel(Level.GOLD);*/
        user.upgradeLevel();
        userDao.update(user);
    }

    public void add(User user) {
        if(user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
