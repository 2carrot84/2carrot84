package study.polymorphism;

/**
 * Created by eguns on 2017. 5. 31..
 */

interface I {
    int x = 0;
    String x();
    String y();
}

interface I2 {
    int y = 1;
    String y();
}

class ClazzI implements I, I2 {
    int x = -1;
    @Override
    public String x() {
        return "x : " + x;
    }

    @Override
    public String y() {
        return "y : " + y;
    }
}

public class Demo2 {
    public static void main(String[] args) {
        I i = new ClazzI();

        System.out.println(i.x());
//        System.out.println(i.y());

        I2 i2 = new ClazzI();

//        i2.x();
        System.out.println(i2.y());

        ClazzI c = new ClazzI();

        System.out.println(c.x());
        System.out.println(c.y());
    }
}
