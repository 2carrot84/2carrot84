package helloworld;

public class StringExercise {
	String getMiddle(String word){
		int mid = word.length()/2;
    	return word.length()%2 == 1?word.substring(mid, (mid)+1):word.substring((mid)-1, (mid)+1);    
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("power"));
        System.out.println(se.getMiddle("abcd"));
    }
}
