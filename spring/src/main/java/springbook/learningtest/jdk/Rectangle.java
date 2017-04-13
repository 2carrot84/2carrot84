package springbook.learningtest.jdk;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

