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

        Set<String> set2 = new HashSet<>();
        set2.add("bed");
        set2.add("bedbath");

//        printArray(solution.wordBreakForward(set, "thequickbrownfox"));
//        printArray(solution.wordBreakForward(set, "bedbathandbeyond"));
//        printArray(solution.wordBreakForward(set, "hello"));

        //printArray(solution.wordBreakForward(set2, "bedbath"));
        //printArray(solution.wordBreakBackward(set2, "bedbath"));
        printArray(solution.wordBreakRecursion(set2, "bedbath"));
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
