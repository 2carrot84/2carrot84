package springbook.user.domain;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by eguns on 2017. 5. 16..
 */
public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void upgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if(level.nextLevel() == null) continue;

            user.setLevel(level);
            user.upgradeLevel();
            Assert.assertThat(user.getLevel(), is(level.nextLevel()));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotUpgradedLevel() {
        Level[] levels = Level.values();
        for (Level level: levels) {
            if(level.nextLevel() != null) continue;

            user.setLevel(level);
            user.upgradeLevel();

        }
    }
}
