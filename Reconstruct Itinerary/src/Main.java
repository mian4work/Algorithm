import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        // Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
        System.out.println();
        Solution solution = new Solution();
        List<List<String>> tickets = convert(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}});
        List<List<String>> tickets2 = convert(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}});
        List<String> iten = solution.findItinerary(tickets);
        return;
    }

    static List<List<String>> convert(String[][] strings) {
        List<List<String>> ans = new ArrayList<>();
        for(String[] s : strings) {
            List<String> list = new ArrayList<>();
            list.add(s[0]);
            list.add(s[1]);
            ans.add(list);
        }

        return ans;
    }
}
