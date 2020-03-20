public class Main {

    public static void main(String[] args) {
	    String[] strings = new String[]{"dog", "deer", "deal"};
	    Solution solution = new Solution(strings);
	    String[] result = solution.search("de");

	    for(int i = 0; i < result.length; i++) {
	    	System.out.println(result[i]);
		}
    }
}
