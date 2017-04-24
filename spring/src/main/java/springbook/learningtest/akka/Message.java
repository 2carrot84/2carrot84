package springbook.learningtest.akka;

import java.io.Serializable;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class Message implements Serializable {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
