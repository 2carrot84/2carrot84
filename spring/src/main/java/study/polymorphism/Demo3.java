package study.polymorphism;

import java.util.Map;

/**
 * Created by eguns on 2017. 5. 31..
 */

abstract class Ca {
    protected int x = 0;

    public abstract String x();
    public void run() {
        System.out.println(this.x());
    }
}

class C1 extends Ca {
    int x = 1;
    @Override
    public String x() {
        return "C1.x : " + x;
    }
}

abstract class C2 extends Ca {
    @Override
    public void run() {
        System.out.println(this.x() + ", " + this.x());
    }
}

public class Demo3 {
    public static void main(String[] args) {
        Ca c = new C1();
        System.out.println(c.x());
        c.run();

        Ca c1 = new C2() {
            @Override
            public String x() {
                return "C2.x";
            }
        };

        c1.run();
    }
}
