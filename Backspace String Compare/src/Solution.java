public class Solution {

    public boolean backspaceCompare(String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0) {
            return false;
        }

        return process(S).equals(process(T));
    }

    String process(String s) {
        int index = 0;
        while(index < s.length()) {
            if(s.charAt(index >= 0 ? index : 0) == '#') {
                if(index == 0) {
                    s = s.substring(1); //when the first char is #
                } else {
                    int start = index - 1 >= 0 ? index - 1 : 0;
                    int end = index + 1 < s.length() ? index + 1 : s.length();
                    String remove = s.substring(start, end);
                    s = s.substring(0, start) + s.substring(end);
                    index = index - 1;
                }

            } else {
                index++;
            }
        }

        return s;
    }
}
