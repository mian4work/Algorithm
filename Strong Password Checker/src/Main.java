public class Main {

    public static void main(String[] args) {

        String pw1 = "abcd0";
        String pw2 = "Aabc$0ud";
        String pw3 = "Abbbb%f";
        Solution solution = new Solution();
        System.out.println(pw1);
        System.out.println(solution.strongPasswordChecker(pw1));
        System.out.println(pw2);
        System.out.println(solution.strongPasswordChecker(pw2));
        System.out.println(pw3);
        System.out.println(solution.strongPasswordChecker(pw3));
    }
}
