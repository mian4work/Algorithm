import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    //printList(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        //printList(solution.groupAnagrams(new String[]{"yup", "pup"}));

        System.out.println(solution.sort("algorithm"));
    }

    static void printList(List<List<String>> list) {
        for(int i = 0; i < list.size(); i++) {
            List<String> subList = list.get(i);
            for(int j = 0; j < subList.size(); j++) {
                System.out.print("[" + subList.get(j) + "]");
            }
            System.out.println();
        }
    }
}
