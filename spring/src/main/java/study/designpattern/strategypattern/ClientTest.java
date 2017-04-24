package study.designpattern.strategypattern;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eguns on 2017. 4. 24..
 */
public class ClientTest {
    @Test
    public void useCosoleLogging() {
        final Client c = new Client(new ConsoleLogging());
        c.doWork(32);
    }

    @Test
    public void useFileLogging() throws IOException {
        final File tempFile = File.createTempFile("test","log");
        final Client c = new Client(new FileLogging(tempFile));

        c.doWork(41);
        c.doWork(42);
        c.doWork(43);

        final BufferedReader reader = new BufferedReader(new FileReader(tempFile));

        Assert.assertEquals("Even number : 42", reader.readLine());
        Assert.assertEquals(null, reader.readLine());
    }
}
