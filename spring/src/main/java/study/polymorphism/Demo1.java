package study.polymorphism;

/**
 * Created by eguns on 2017. 5. 31..
 */
class A {
    public String x() { return "A.x"; }
}
class B extends A {
    public String y() {return "y";}
    public String x() {return "B.x";}
}

class B2 extends A {
    public String x() {return  "B2.x";}
}

public class Demo1 {
    public static void execute(A a) {
        System.out.println(a.getClass().getName() + ", " + a.x());
    }

    public static void main(String[] args) {

        A a = new B();
        System.out.println(a.x());
        // 다형성 오류
        // a.y();
        // 오류
        // B b = new A();
        B b = new B();
        System.out.println(b.x());
        System.out.println(b.y());

        A c = new A();
        System.out.println(c.x());

        A d = new B2();
        System.out.println(d.x());
//        System.out.println(d.y());

        execute(a);
        execute(b);
        execute(c);
        execute(d);

//        B2 b2 = (B2)b;
//        can not cast
        A b2 = (A)b;

        execute(b2);
    }
}
