package codinginterview;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class StringBufferStudy {

    public String joinWords(String[] words) {
        // String의 경우 + 될때 마다 새로운 문자열 객체가 생성, 문자 단위로 복사
        // 길이가 x인 n개의 문자열을  O(x+2x+3x+ ... + nx) = O(nx2)

        String sentence = "";

        for (String w: words) {
            sentence += sentence + w;
        }
        return sentence;
    }

    public String joinWordsSb(String[] words) {
        // 모든 문자열의 배열을 만들어두고 문자열의 객체로의 복사는 필요할때만 수행
        StringBuffer sb = new StringBuffer();

        for (String w : words
             ) {
            sb.append(w);
        }

        return sb.toString();
    }
}
