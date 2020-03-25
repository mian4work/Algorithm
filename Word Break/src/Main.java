import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.wordBreakBruteForce("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreakBruteForce("aaaaaaa", List.of("aaaa","aaa")));

        System.out.println(solution.wordBreakQueue("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreakQueue("aaaaaaa", List.of("aaaa","aaa")));

        System.out.println(solution.wordBreakDFS("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreakDFS("aaaaaaa", List.of("aaaa","aaa")));

        System.out.println(solution.wordBreakDP("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreakDP("aaaaaaa", List.of("aaaa","aaa")));
    }
}
