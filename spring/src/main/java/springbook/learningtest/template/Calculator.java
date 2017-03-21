package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by eguns on 2017. 2. 16..
 */
public class Calculator {
	public String concatenate(String filePath) throws IOException {
		LineCallback<String> callback = new LineCallback<String>() {
			@Override
			public String doSomethingsWithLine(String line, String value) {
				// TODO Auto-generated method stub
				return value + line;
			}
		}; 
		
		return this.lineReadTemplate(filePath, callback, "");
	}
	
	public Integer calMultiple(String filePath) throws IOException {
		return this.lineReadTemplate(filePath, new LineCallback<Integer>() {
			@Override
			public Integer doSomethingsWithLine(String line, Integer value) {
				// TODO Auto-generated method stub
				return value * Integer.parseInt(line);
			}
		}, 1);
		
    	/* Integer로 고정된 타입을 제네릭스로 변경
         * LineCallback callback = new LineCallback() {

            @Override
            public Integer doSomethingsWithLine(String line, Integer value) {
                return value * Integer.parseInt(line);
            }
        };

        return this.lineReadTemplate(filePath, callback, 1);*/
        /*
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
        });*/
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

        /*
        계산 로직 제외한 반복되는 로직 분리

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
        */

        /*return this.lineReadTemplate(filePath, new LineCallback() {
                    @Override
                    public Integer doSomethingsWithLine(String line, Integer value) {
                        return value + Integer.parseInt(line);
                    }
                }
        , 0);*/
    	return this.lineReadTemplate(filePath, new LineCallback<Integer>() {
    		@Override
    		public Integer doSomethingsWithLine(String line, Integer value) {
    			// TODO Auto-generated method stub
    			return value + Integer.parseInt(line);
    		}
		}, 0);
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

    /*
     * Integer로 고정된 타입을 제네릭스로 변경
     * public Integer lineReadTemplate(String filePath, LineCallback callback, Integer initVal) throws IOException {
        BufferedReader br = null;
        Integer res = initVal;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingsWithLine(line, res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }*/
    
    public <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initVal) throws IOException {
    	BufferedReader br = null;
    	T res = initVal;
    	
    	try {
    		br = new BufferedReader(new FileReader(filePath));
    		String line = null;
    		while ((line = br.readLine()) != null) {
    			res = callback.doSomethingsWithLine(line, res);
    		}
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	return res;
    }
}
