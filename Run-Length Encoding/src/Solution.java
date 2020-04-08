/*
    This problem was asked by Amazon.

    Run-length encoding is a fast and simple method of encoding strings.
    The basic idea is to represent repeated successive characters as a single count and character.
    For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

    Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and
    consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 */
public class Solution {
    /**
     * Just using brute force to solve this problem.
     * @param s
     * @return
     */
    public String encode(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int p = 0;
        int sum = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(p)) {
                sum++;
            } else {
                builder.append(sum + s.substring(p, p + 1));
                p = i;
                sum = 1;
            }
        }
        builder.append(sum + s.substring(p, p + 1));

        return builder.toString();
    }

    public String decode(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i = i + 2) {
            int n = Integer.valueOf(s.substring(i, i + 1));
            String c = s.substring(i + 1, i + 2);
            while(n > 0) {
                builder.append(c);
                n--;
            }
        }

        return builder.toString();
    }
}
