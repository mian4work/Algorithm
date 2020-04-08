import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    String[] words = new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
	    printList(solution.justify(words, 16));

	    solution.group(words, 16);
    }

    static void printList(List<String> list) {
        for(String s : list) {
            System.out.println("[" + s + "]");
        }
    }
}
