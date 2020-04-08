public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println("encode: AAAABBBCCDAA to " + solution.encode("AAAABBBCCDAA"));
        System.out.println("encode: ABCDEFG to " + solution.encode("ABCDEFG"));

        System.out.println("decode: 4A3B2C1D2A to " + solution.decode("4A3B2C1D2A"));
        System.out.println("decode: 1A1B1C1D1E1F1G to " + solution.decode("1A1B1C1D1E1F1G"));
    }
}
