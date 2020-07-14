import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    Solution1 solution1 = new Solution1();
	    System.out.println(solution1.lengthEachScene(Arrays.asList(new Character[]{'a', 'b', 'a', 'b', 'f'})));

	    Solution2 solution2 = new Solution2();
	    int[][] array = new int[][]{{1,0,0,1}, {1,0,1,0}, {1,1,0,1}};
	    List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < array[i].length; j++){
                l.add(array[i][j]);
            }
            list.add(l);
        }
	    System.out.println(solution2.numberAmazonTreasureTrucks(3, 4, list));
    }
}
