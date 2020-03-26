public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    char[] s1 = new char[]{'h','e','l','l','o'};
	    printChar(s1);
	    solution.reverseString(s1);
	    printChar(s1);
    }

    static void printChar(char[] s) {
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        System.out.println();
    }
}
