package springbook.user.service.mockDao;

import org.junit.Before;
import org.junit.Test;
<<<<<<< HEAD
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import springbook.user.dao.aop.MockUserDao;
import springbook.user.dao.aop.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static springbook.user.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;

/**
 * Created by eguns on 2017. 5. 16..
 */
public class UserServiceTest {
    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0, "bumjin@naver.com"),
                new User("joytouch", "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0, "joytuch@naver.com"),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1, "erwins@naver.com"),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD, "madnite1@naver.com"),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MIN_VALUE, "green@naver.com")
        );
    }

    @Test
    public void mockUpgradeLevels() throws Exception {
    	UserServiceImpl userServiceImpl = new UserServiceImpl();
    	
    	UserDao mockUserDao = mock(UserDao.class);
    	when(mockUserDao.getAll()).thenReturn(this.users);
    	userServiceImpl.setUserDao(mockUserDao);
    	
    	MailSender mockMailSender = mock(MailSender.class);
    	userServiceImpl.setMailSender(mockMailSender);
    	
    	userServiceImpl.upgradeLevels();
    	
    	verify(mockUserDao, times(2)).update(any(User.class));
//    	verify(mockUserDao, times(2)).update(any(User.class));
    	verify(mockUserDao).update(users.get(1));
    	assertThat(users.get(1).getLevel(), is(Level.SILVER));
    	verify(mockUserDao).update(users.get(3));
    	assertThat(users.get(3).getLevel(), is(Level.GOLD));
    	
    	ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);
    	
    	verify(mockMailSender, times(2)).send(mailMessageArg.capture());
    	List<SimpleMailMessage> mailMessage = mailMessageArg.getAllValues();
    	
    	assertThat(mailMessage.get(0).getTo()[0], is(users.get(1).getEmail()));
    	assertThat(mailMessage.get(1).getTo()[0], is(users.get(3).getEmail()));
    }
    
=======
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import springbook.user.dao.aop.MockUserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static springbook.user.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;

/**
 * Created by eguns on 2017. 5. 16..
 */
public class UserServiceTest {
    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER-1, 0, "bumjin@naver.com"),
                new User("joytouch", "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0, "joytuch@naver.com"),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD-1, "erwins@naver.com"),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD, "madnite1@naver.com"),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MIN_VALUE, "green@naver.com")
        );
    }

>>>>>>> refs/remotes/origin/master
    @Test
    public void upgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        MockUserDao mockUserDao = new MockUserDao(users);
        userServiceImpl.setUserDao(mockUserDao);

        MockMailSender mockMailSender = new MockMailSender();
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        List<User> updated = mockUserDao.getUpdated();

        assertThat(updated.size(), is(2));
        checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER);
        checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);

        List<String> request = mockMailSender.getRequests();

        assertThat(request.size(), is(2));
        assertThat(request.get(0), is(users.get(1).getEmail()));
        assertThat(request.get(1), is(users.get(3).getEmail()));
    }

    private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
        assertThat(updated.getId(), is(expectedId));
        assertThat(updated.getLevel(), is(expectedLevel));
    }

    static class MockMailSender implements MailSender {
        private List<String> requests = new ArrayList<>();

        public List<String> getRequests() {
            return requests;
        }

        @Override
        public void send(SimpleMailMessage simpleMailMessage) throws MailException {
            requests.add(simpleMailMessage.getTo()[0]);
        }

        @Override
        public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

        }
    }
}

