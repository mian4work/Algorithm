import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    List<Integer> list = new ArrayList<>();
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    List<List<Integer>> power = solution.powerSet(list);
	    return;
    }
}
