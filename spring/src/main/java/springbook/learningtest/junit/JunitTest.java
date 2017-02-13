package springbook.learningtest.junit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by 154910 on 2017-02-02.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class JunitTest {
    @Autowired
    ApplicationContext context;

    static Set<JunitTest> testObjects = new HashSet<JunitTest>();
    //static JunitTest testObject;
    static ApplicationContext contextObject = null;

    @Test
    public void test1() {
        /* 테스트 개선
        Assert.assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;*/
        Assert.assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);
        Assert.assertThat(contextObject == null || contextObject  == this.context, is(true));
        contextObject = this.context;
    }

    @Test
    public void test2() {
        /* 테스트 개선
        Assert.assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;*/
        Assert.assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);
        Assert.assertTrue(contextObject == null || contextObject  == this.context);
        contextObject = this.context;
    }

    @Test
    public void test3() {
        /* 테스트 개선
        Assert.assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;*/
        Assert.assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);

        Assert.assertThat(contextObject, either(is(nullValue())).or(CoreMatchers.<Object>is(this.context)));
        contextObject = this.context;
    }

}
