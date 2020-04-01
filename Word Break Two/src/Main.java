import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
	    Set<String> set = new HashSet<>();
	    set.add("quick");
        set.add("brown");
        set.add("the");
        set.add("fox");
        set.add("bed");
        set.add("bath");
        set.add("bedbath");
        set.add("and");
        set.add("beyond");

        printArray(solution.wordBreak(set, "thequickbrownfox"));
        printArray(solution.wordBreak(set, "bedbathandbeyond"));
        printArray(solution.wordBreak(set, "hello"));
    }

    private static void printArray(String[] strings) {
        if(strings == null) {
            System.out.print("NULL");
        } else {
            for (String s : strings) {
                System.out.print("[" + s + "]");
            }
            System.out.println();
        }
    }
}
