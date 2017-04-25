package study.designpattern.strategypattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by eguns on 2017. 4. 24..
 */
public class FileLogging implements Logging {
    private final File toWrite;

    public FileLogging(final File toWrite) {
        this.toWrite = toWrite;
    }

    @Override
    public void write(String message) {
        try {
            final FileWriter fos = new FileWriter(toWrite);
            fos.write(message);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}