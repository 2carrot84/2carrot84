package springbook.learningtest.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by eguns on 2017. 4. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Autowired
    Message m;

    @Test
    public void getMessageFromFactoryBean() {
        Message message = (Message)context.getBean("message");
        assertThat(message, is(Message.class));
        assertThat(message.getText(), is("Factory Bean"));
    }

    @Test
    public void getFactoryBean() {
        Object factory = context.getBean("&message");
        assertThat((MessageFactoryBean)factory, is(MessageFactoryBean.class));

    }

    @Test
    public void autoWiredFactoryBean() {
        assertThat(m.getText(), is("Factory Bean"));
        assertTrue(m instanceof Message);
    }
}
