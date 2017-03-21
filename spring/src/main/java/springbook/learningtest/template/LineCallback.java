package springbook.learningtest.template;

/**
 * Created by eguns on 2017. 3. 20..
 */
public interface LineCallback<T> {
//    Integer doSomethingsWithLine(String line, Integer value);
    /* Integer로 고정된 타입을 제네릭스로 변경 */
    T doSomethingsWithLine(String line, T value);
}
