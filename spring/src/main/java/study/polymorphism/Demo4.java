package study.polymorphism;

/**
 * Created by eguns on 2017. 5. 31..
 */

interface Ia {
    String x();
}

class CI implements Ia {
    @Override
    public String x() {
        return "CI";
    }
}

class CI2 implements Ia {
    @Override
    public String x() {
        return "CI2";
    }
}

public class Demo4 {
    public static void main(String[] args) {
        Ia i1 = new CI();
        Ia i2 = new CI2();

        System.out.println(i1.x());
        System.out.println(i2.x());
    }
}

