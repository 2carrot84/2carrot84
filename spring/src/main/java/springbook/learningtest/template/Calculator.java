package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eguns on 2017. 2. 16..
 */
public class Calculator {
    public Integer calMultiple(String filePath) throws IOException {
        return this.fileReaderTemplate(filePath, new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                String line = null;
                int multiple = 1;
                while ((line = br.readLine()) != null) {
                    multiple *= Integer.parseInt(line);
                }
                return multiple;
            }
        });
    }

    public Integer calSum(String filePath) throws IOException {
        /*
        예외 처리 전 소스
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Integer sum = 0;
        String line = null;

        while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
        }

        br.close();
        return sum;*/

        /*
        BufferReader 공통 소스 분리 -> 콜백 인터페이스

        BufferedReader br = null;
        Integer sum = 0;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        return this.fileReaderTemplate(filePath, new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                String line = null;
                int sum = 0;
                while ((line = br.readLine()) != null) {
                    sum += Integer.parseInt(line);
                }
                return sum;
            }
        });
    }

    public Integer fileReaderTemplate(String filePath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        Integer ret = 0;

        try {
            br = new BufferedReader(new FileReader(filePath));
            ret = callback.doSomethingWithReader(br);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }
}
