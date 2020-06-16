public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
//	    System.out.println(solution.validIPAddress("172.16.254.1."));
        System.out.println(solution.validIPAddress("172.-1.254.1"));
//        System.out.println(solution.validIPAddress("172.16.254.01"));
//        System.out.println(solution.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
//        System.out.println(solution.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(solution.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
        System.out.println(solution.validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
