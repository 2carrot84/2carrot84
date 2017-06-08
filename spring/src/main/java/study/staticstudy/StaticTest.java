package study.staticstudy;

/**
 * Created by eguns on 2017. 6. 5..
 */
public class StaticTest {
    private static String str = "1234";
    private String str2 = "5678";

    public static void method() {
        System.out.println(str);
        // error : static 메소드 내에선 일반 인스턴스 변수 사용 불가
//        System.out.println(str2);
    }

    public void method2() {
        System.out.println(str);
        System.out.println(str2);
    }

    public static void main(String[] args) {
        StaticTest.method();
//      error : 일반 메소드는 인스턴스 생성 후 사용
//      StaticTest.method2();

        StaticTest st = new StaticTest();
        st.method2();
    }
}
