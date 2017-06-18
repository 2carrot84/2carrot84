package springbook.user.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import springbook.user.dao.jdbcTemplate.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

/**
 * Created by eguns on 2017. 5. 16..
 */
public class UserServiceImpl implements UserService, UserLevelUpgradePolicy {
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMEND_FOR_GOLD = 30;

    UserDao userDao;
//    private DataSource dataSource;
//    private PlatformTransactionManager transactionManager;
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    public void setTransactionManager(PlatformTransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }

    public void upgradeLevels() {
//        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
//        try {

            List<User> users = userDao.getAll();

            for (User user : users) {
                if(canUpdatedLevel(user)) {
                    upgradeLevel(user);
                }
            }
//            transactionManager.commit(status);
//        }
//        catch (Exception e) {
//            transactionManager.rollback(status);
//            throw e;
//        }
    }

    /*
    transaction 동기화 적용 소스
    public void upgradeLevels() throws Exception {
        TransactionSynchronizationManager.initSynchronization();
        Connection c = DataSourceUtils.getConnection(dataSource);
        c.setAutoCommit(false);

        try {

            List<User> users = userDao.getAll();

            for (User user : users) {
                if(canUpdatedLevel(user)) {
                    upgradeLevel(user);
                }
            *//*
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
            }*//*
            }
            c.commit();
        }
        catch (Exception e) {
            c.rollback();
            throw e;
        }
        finally {
            DataSourceUtils.releaseConnection(c,dataSource);
            TransactionSynchronizationManager.unbindResource(this.dataSource);
            TransactionSynchronizationManager.clearSynchronization();
        }
    }*/

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
        sendUpgradeEMail(user);
    }

    private void sendUpgradeEMail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("useradmin@ksug.org");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText(user.getName()+ " 님의 등깁이 " + user.getLevel().name() + " 로 업그레이드 되었습니다.");

        this.mailSender.send(mailMessage);
    }
    /*private void sendUpgradeEMail(User user) {
        Properties props = new Properties();
        props.put("mail.stmp.host", "mail.ksug.org");
        Session s = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(s);

        try {
            message.setFrom(new InternetAddress("useradmin@ksug.org"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Upgrade 안내");
            message.setText(user.getName()+ " 님의 등깁이 " + user.getLevel().name() + " 로 업그레이드 되었습니다.");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }*/

    public void add(User user) {
        if(user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
