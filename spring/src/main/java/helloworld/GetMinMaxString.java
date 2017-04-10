package helloworld;

/**
 * Created by eguns on 2017. 4. 9..
 */
public class GetMinMaxString {
    public String getMinMaxString(String str) {
        String[] array = str.split(" ");
        int max = 0;
        int min = 0;

        for (int i = 0; i < array.length; i++) {
            int val = Integer.parseInt(array[i]);

            if(i == 0) {
                max = val;
                min = val;
            }
            else {
                if(max < val) max = val;
                if(min > val) min = val;
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        String str = "1 2 3 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}