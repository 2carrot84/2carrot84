package springbook.learningtest.factorybean;

/**
 * Created by eguns on 2017. 4. 12..
 */
public class Message {
    String text;

    private Message(String text) {
        this.text = text;
    }   // 생성자를 통해 오브젝트를 만들 수 없다

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Message newMessage(String text) {
        return new Message(text);
    }   // 해당 static 메소드를 통해 생성 가능
}
