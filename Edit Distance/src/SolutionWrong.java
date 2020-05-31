/*
    The edit distance between two strings refers to the minimum number of character insertions, deletions, and
    substitutions required to change one string to the other.

    For example, the edit distance between “kitten” and “sitting” is three:
    substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

    Given two strings, compute the edit distance between them.
 */
public class SolutionWrong {
    /**
     * A easy one. The key is to keep increase the distance when one of the string is run out.
     * @param a
     * @param b
     * @return
     */
    public int distance(String a, String b) {
        if(a == null || a.length() == 0 || b == null || b.length() == 0 || a.equals(b)) {
            return 0;
        }

        int distance = 0, index = 0;
        int length = Math.max(a.length(), b.length());

        while(index < length) {
            if(index > a.length() - 1) {
                distance++;
            } else if(index > b.length() - 1) {
                distance++;
            } else {
                if(a.charAt(index) != b.charAt(index)) {
                    distance++;
                }
            }

            index++;
        }

        return distance;
    }
}
