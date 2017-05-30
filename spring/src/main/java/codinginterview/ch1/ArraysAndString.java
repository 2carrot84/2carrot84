package codinginterview.ch1;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class ArraysAndString {
    public boolean p1(String input) {
        int length = 0;
        for (char c : input.toCharArray()) {
            length = input.split(String.valueOf(c)).length;
            if(length == 0 || length > 2)
                return false;
        }

        return true;
    }

    public boolean isUniqueChars2(String str) {
        if(str.length() > 256) return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) return false;

            char_set[val] = true;
        }

        return true;
    }
}
