public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    printChar(solution.shiftTwoLoop(new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'}));
        printChar(solution.shift(new char[]{'R', 'R', 'R', 'G', 'R', 'R', 'R'}));

    }

    static void printChar(char[] rgb) {
        for(int i = 0; i < rgb.length; i++) {
            System.out.print("[" + rgb[i] + "]");
        }
        System.out.println();
    }
}
